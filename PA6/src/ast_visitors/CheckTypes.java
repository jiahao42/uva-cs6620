package ast_visitors;

/** 
 * CheckTypes
 * 
 * This AST visitor traverses a MiniJava Abstract Syntax Tree and checks
 * for a number of type errors.  If a type error is found a SymanticException
 * is thrown
 * 
 * CHANGES to make next year (2012)
 *  - make the error messages between *, +, and - consistent <= ??
 *
 * Bring down the symtab code so that it only does get and set Type
 *  for expressions
 */

import ast.node.*;
import ast.visitor.DepthFirstVisitor;
import java.util.*;

import symtable.SymTable;
import symtable.*;
import exceptions.InternalException;
import exceptions.SemanticException;

public class CheckTypes extends DepthFirstVisitor {

  private SymTable mCurrentST;

  public CheckTypes(SymTable st) {
    if (st == null) {
      throw new InternalException("unexpected null argument");
    }
    mCurrentST = st;
  }

  private boolean isByte(Type t) {
    return t == Type.BYTE;
  }

  private boolean isIntOrByte(Type t) {
    return (t == Type.INT || t == Type.BYTE);
  }

  private boolean isBoolean(Type t) {
    return t == Type.BOOL;
  }

  private boolean isButton(Type t) {
    return t == Type.BUTTON;
  }

  private boolean isVoid(Type t) {
    return t == Type.VOID;
  }

  private boolean isColor(Type t) {
    return t == Type.COLOR;
  }

  private boolean isTone(Type t) {
    return t == Type.TONE;
  }

  private Type getType(Node node) {
    if (node == null) {
      return Type.VOID;
    }
    return this.mCurrentST.getExpType(node);
  }

  private void setType(Node node, Type t) {
    this.mCurrentST.setExpType(node, t);
  }

  // ========================= Overriding the visitor interface

  @Override
  public void defaultOut(Node node) {
    // System.err.println("Node not implemented in CheckTypes, " + node.getClass());
  }

  /** Type check for Experssions **/

  @Override
  public void outIdLiteral(IdLiteral node) {
    VarSTE varSTE = mCurrentST.lookupVar(node.getLexeme());
    if (varSTE != null) {
      setType(node, varSTE.getType());
    } else {
      throw new SemanticException(
        "ID [" + node.getLexeme() + "] is not defined under scope " + mCurrentST.getCurrentScope().getName(), 
        node.getLine(),
        node.getPos());
    }
  }
  

  /* Functions */

  @Override
  public void outMeggyCheckButton(MeggyCheckButton node) {
    if (isButton(getType(node.getExp()))) {
      setType(node, Type.BOOL);
    } else {
      throw new SemanticException(
        "Invalid parameter type for Meggy.checkButton, expect: BUTTON, actual: " + getType(node.getExp()).toString(), 
        node.getExp().getLine(),
        node.getExp().getPos());
    }
  }
  
  @Override
  public void outMeggyGetPixel(MeggyGetPixel node) {
    Type x = getType(node.getXExp());
    Type y = getType(node.getYExp());
    if (isIntOrByte(x) && isIntOrByte(y)) {
      setType(node, Type.COLOR);
    } else {
      throw new SemanticException(
        "Invalid parameter types for Meggy.getPixel, expect: (BYTE, BYTE), actual: (" + x.toString() + ", " + y.toString() + ")", 
        node.getXExp().getLine(),
        node.getXExp().getPos());
    }
  }
  
  /* Operators */

  @Override
  public void outAndExp(AndExp node) {
    if (getType(node.getLExp()) != Type.BOOL) {
      throw new SemanticException(
        "Invalid left operand type for operator &&, expect: BOOL, actual: " + getType(node.getLExp()).toString(), 
        node.getLExp().getLine(),
        node.getLExp().getPos());
    }
    if (getType(node.getRExp()) != Type.BOOL) {
      throw new SemanticException(
        "Invalid right operand type for operator &&, expect: BOOL, actual: " + getType(node.getRExp()).toString(), 
        node.getRExp().getLine(),
        node.getRExp().getPos());
    }
    setType(node, Type.BOOL);
  }

  /* 
  shouldn't be VOID,
  if they are BYTE and INT, expand BYTE to INT
  */
  @Override
  public void outEqualExp(EqualExp node) {
    Type lExpType = getType(node.getLExp());
    Type rExpType = getType(node.getRExp());
    if (isVoid(lExpType) || isVoid(rExpType)) {
      throw new SemanticException("Invalid operands type for operator ==, type cannot be VOID", node.getLine(),
          node.getPos());
    } else if (isIntOrByte(lExpType) && isIntOrByte(rExpType)) {
      setType(node, Type.BOOL);
    } else if (lExpType == rExpType) {
      setType(node, Type.BOOL);
    } else {
        throw new SemanticException(
          "Invalid operands type for operator ==, expect same type on left and right, left: " + lExpType.toString() + ", right: " + rExpType.toString(), 
          node.getLine(),
          node.getPos());
    }
  }

  @Override
  public void outPlusExp(PlusExp node) {
    Type lExpType = getType(node.getLExp());
    Type rExpType = getType(node.getRExp());
    if (isIntOrByte(lExpType) && isIntOrByte(rExpType)) {
      setType(node, Type.INT);
    } else {
      throw new SemanticException(
        "Invalid operands type for operator +, expect: (INT or BYTE, INT or BYTE), actual: (" + lExpType.toString() + ", " + rExpType.toString() + ")", 
        node.getLine(),
        node.getPos());
    }
  }

  @Override
  public void outMinusExp(MinusExp node) {
    Type lExpType = getType(node.getLExp());
    Type rExpType = getType(node.getRExp());
    if (isIntOrByte(lExpType) && isIntOrByte(rExpType)) {
      setType(node, Type.INT);
    } else {
      throw new SemanticException(
        "Invalid operands type for operator -, expect: (INT or BYTE), actual: (" + lExpType.toString() + ", " + rExpType.toString() + ")", 
        node.getLine(),
        node.getPos());
    }
  }
  
  @Override
  public void outMulExp(MulExp node) {
    Type lExpType = getType(node.getLExp());
    Type rExpType = getType(node.getRExp());
    if (isByte(lExpType) && isByte(rExpType)) {
      setType(node, Type.INT);
    } else {
      throw new SemanticException(
        "Invalid operands type for operator *, expect: (BYTE, BYTE), actual: (" + lExpType.toString() + ", " + rExpType.toString() + ")", 
        node.getLine(),
        node.getPos());
    }
  }
  
  @Override
  public void outNegExp(NegExp node) {
    if (isIntOrByte(getType(node.getExp()))) {
      setType(node, Type.INT); // use INT
    } else {
      throw new SemanticException(
        "Invalid operands type for operator -, expect: INT or BYTE, actual: " + getType(node.getExp()).toString(), 
        node.getLine(),
        node.getPos());
    }
  }
  
  @Override
  public void outLtExp(LtExp node) {
    if (!isIntOrByte(getType(node.getLExp()))) {
      throw new SemanticException(
        "Invalid left operand type for operator <, expect: INT or BYTE, actual: " + getType(node.getLExp()).toString(), 
        node.getLExp().getLine(),
        node.getLExp().getPos());
    } else if (!isIntOrByte(getType(node.getRExp()))) {
      throw new SemanticException(
        "Invalid right operand type for operator <, expect INT or BYTE, actual: " + getType(node.getRExp()).toString(), 
        node.getLExp().getLine(),
        node.getRExp().getPos());
    }
    setType(node, Type.BOOL);
  }

  @Override
  public void outByteCast(ByteCast node) {
    if (isIntOrByte(getType(node.getExp()))) {
      setType(node, Type.BYTE);
    } else {
      throw new SemanticException(
        "Invalid operand type for byte cast, expect: INT or BYTE, actual: " + getType(node.getExp()).toString(), 
        node.getLine(),
        node.getPos());
    }
  }

  @Override
  public void outNotExp(NotExp node) {
    if (isBoolean(getType(node.getExp()))) {
      setType(node, Type.BOOL);
    } else {
      throw new SemanticException(
        "Invalid operand type for !, expect: BOOL, actual: " + getType(node.getExp()).toString(), 
        node.getLine(),
        node.getPos());
    }
  }

  @Override
  public void outNewExp(NewExp node) {
    ClassSTE classSTE = mCurrentST.lookupClass(node.getId());
    if (classSTE != null) {
      setType(node, Type.getOrCreateType(classSTE.getName()));
    } else {
      throw new SemanticException(
        "Name [" + node.getId() + "] is not defined under scope " + mCurrentST.getCurrentScope().getName(), 
        node.getLine(),
        node.getPos());
    }
  }
  
  /** Type check for statement **/

  @Override
  public void outMeggySetPixel(MeggySetPixel node) {
    Type xExpType = getType(node.getXExp());
    Type yExpType = getType(node.getYExp());
    Type colorType = getType(node.getColor());
    if (isIntOrByte(xExpType) && 
        isIntOrByte(yExpType) &&
        isColor(colorType)) {
          setType(node, Type.VOID);
        } else {
          throw new SemanticException(
            "Invalid parameter types for Meggy.setPixel, expect: (BYTE, BYTE, COLOR), actual: (" + xExpType.toString() + ", " + yExpType.toString() + ", " + colorType.toString() + ")", 
            node.getLine(),
            node.getPos());
        }
  }
  
  @Override
  public void outMeggyDelay(MeggyDelay node) {
    if (isIntOrByte(getType(node.getExp()))) {
      setType(node, Type.VOID);
    } else {
      throw new SemanticException(
        "Invalid parameter types for Meggy.delay, expect: INT, actual: " + getType(node.getExp()).toString(), 
        node.getLine(),
        node.getPos());
    }
  }

  @Override
  public void outMeggyToneStart(MeggyToneStart node) {
    if (!isTone(getType(node.getToneExp()))) {
      throw new SemanticException(
        "Invalid parameter types for Meggy.toneStart, expect: TONE, actual: " + getType(node.getToneExp()).toString(), 
        node.getToneExp().getLine(),
        node.getToneExp().getPos());
    }
    if (!isIntOrByte(getType(node.getDurationExp()))) {
      throw new SemanticException(
        "Invalid parameter types for Meggy.toneStart, expect: INT, actual: " + getType(node.getDurationExp()).toString(), 
        node.getDurationExp().getLine(),
        node.getDurationExp().getPos());
    }
    setType(node, Type.VOID);
  }
  
  @Override
  public void visitIfStatement(IfStatement node) {
    inIfStatement(node);
    if (node.getExp() != null) {
      node.getExp().accept(this);
    }
    if (!isBoolean(getType(node.getExp()))) {
      throw new SemanticException(
        "Invalid condition type for if statement, expect: BOOL, actual: " + getType(node.getExp()).toString(), 
        node.getLine(),
        node.getPos());
    }
    if (node.getThenStatement() != null) {
      node.getThenStatement().accept(this);
    }
    if (node.getElseStatement() != null) {
      node.getElseStatement().accept(this);
    }
  }
  
  @Override
  public void visitWhileStatement(WhileStatement node) {
    if (node.getExp() != null) {
      node.getExp().accept(this);
    }
    if (!isBoolean(getType(node.getExp()))) {
      throw new SemanticException(
        "Invalid condition type for while statement, expect: BOOL, actual: " + getType(node.getExp()).toString(), 
        node.getLine(),
        node.getPos());
    }
    if (node.getStatement() != null) {
      node.getStatement().accept(this);
    }
  }

  @Override
  public void outAssignStatement(AssignStatement node) {
    VarSTE var = mCurrentST.lookupVar(node.getId());
    if (var != null) {
      if (var.getType() != getType(node.getExp())) {
        throw new SemanticException(
          "Invalid type in assignment to var [" + node.getId() + "], expect: " + var.getType().toString() + ", actual: " + getType(node.getExp()).toString(), 
          node.getLine(),
          node.getPos());
      }
    } else {
      throw new SemanticException(
        "Var [" + node.getId() + "] is not defined under scope " + mCurrentST.getCurrentScope().getName(), 
        node.getLine(),
        node.getPos());
    }
  }
  
  /** Others **/
  
  @Override
  public void outCallExp(CallExp node) {
    STE ste = mCurrentST.lookup(getType(node.getExp()).toString());
    mCurrentST.pushScope(ste.getScope());
    MethodSTE mSTE = mCurrentST.lookupMethod(node.getId());
    if (mSTE != null) {
      checkMethodParameters(node, mSTE);
      setType(node, mSTE.getSignature().getReturnType());
    } else {
      throw new SemanticException(
        "Method [" + node.getId() + "] is not defined under scope " + mCurrentST.getCurrentScope().getName(), 
        node.getLine(),
        node.getPos());
    }
    mCurrentST.popScope();
  }

  @Override
  public void outCallStatement(CallStatement node) {
    boolean enterScope = true;
    if (node.getExp() instanceof ThisLiteral) {
      enterScope = false;
    }
    STE ste;
    if (enterScope) {
      ste = mCurrentST.lookup(getType(node.getExp()).toString());
      mCurrentST.pushScope(ste.getScope());
    }
    MethodSTE mSTE = mCurrentST.lookupMethod(node.getId());
    if (mSTE != null) {
      checkMethodParameters(node, mSTE);
      setType(node, mSTE.getSignature().getReturnType());
    } else {
      throw new SemanticException(
        "Method [" + node.getId() + "] is not defined under scope " + mCurrentST.getCurrentScope().getName(), 
        node.getLine(),
        node.getPos());
    }
    if (enterScope) {
      mCurrentST.popScope();
    }
  }

  private void checkMethodParameters(FuncCall node, MethodSTE mSTE) {
    /* Check if the parameters are valid */
    List<Type> expectedTypes = mSTE.getSignature().getParamTypes();
    List<Type> actualTypes = new LinkedList<>();
    for (IExp e : node.getArgs()) {
      actualTypes.add(getType(e));
    }
    String actualTypeString = typeList2String(actualTypes);
    String expectTypeString = typeList2String(expectedTypes);
    if (expectedTypes.size() != actualTypes.size()) {
      throw new SemanticException(
        "Calling method [" + node.getId() + "] with wrong number of parameters, expect: " + expectTypeString + ", actual: " + actualTypeString,
        node.getLine(),
        node.getPos());
    }
    for (int i = 0; i < actualTypes.size(); i++) {
      if (actualTypes.get(i) != expectedTypes.get(i)) {
        throw new SemanticException(
          "Calling method [" + node.getId() + "] with wrong type of parameters, expect: " + expectTypeString + ", actual: " + actualTypeString,
          node.getLine(),
          node.getPos());
      }
    }
  }

  private String typeList2String(List<Type> list) {
    if (list.size() == 0) return "()";
    String s = "(";
    for (Type t : list) {
      s += t.toString() + ",";
    }
    s = s.substring(0, s.lastIndexOf(","));
    s += ")";
    return s;
  }

  @Override
  public void visitMethodDecl(MethodDecl node) {
    assert (mCurrentST.getCurrentScope().getScopeType() == Scope.classScope);
    MethodSTE methodSTE = mCurrentST.lookupMethod(node.getName());
    if (methodSTE != null) {
      mCurrentST.pushScope(methodSTE.getScope());
    } else {
      throw new SemanticException(
        "Method [" + node.getName() + "] is not defined under scope " + mCurrentST.getCurrentScope().getName(), 
        node.getLine(),
        node.getPos());
    }
    if (node.getType() != null) {
      node.getType().accept(this);
    }
    {
      List<Formal> copy = new ArrayList<Formal>(node.getFormals());
      for (Formal e : copy) {
        e.accept(this);
      }
    }
    {
      List<VarDecl> copy = new ArrayList<VarDecl>(node.getVarDecls());
      for (VarDecl e : copy) {
        e.accept(this);
      }
    }
    {
      List<IStatement> copy = new ArrayList<IStatement>(node.getStatements());
      for (IStatement e : copy) {
        e.accept(this);
      }
    }
    if (node.getExp() != null) {
      node.getExp().accept(this);
    }
    /* Check for conflict in ret type */
    Type declaredType = methodSTE.getSignature().getReturnType();
    Type retType = getType(node.getExp());
    // System.out.println(node.getName());
    // System.out.println(declaredType.toString());
    // System.out.println(retType.toString() + "yo");
    if (retType != declaredType) {
      throw new SemanticException(
        "Invalid return type for Method[" + node.getName() + "], expect: " + declaredType.toString() + ", actual: " + retType.toString(), 
        node.getLine(),
        node.getPos());
    }
    mCurrentST.popScope();
  }
  
  @Override
  public void inTopClassDecl(TopClassDecl node) {
    assert (mCurrentST.getCurrentScope() == mCurrentST.getGlobalScope());
    ClassSTE classSTE = mCurrentST.lookupClass(node.getName());
    if (classSTE != null) {
      mCurrentST.pushScope(classSTE.getScope());
    } else {
      throw new SemanticException(
        "Class [" + node.getName() + "] is not defined under scope " + mCurrentST.getCurrentScope().getName(), 
        node.getLine(),
        node.getPos());
    }
    mCurrentST.pushScope(classSTE.getScope());
  }

  @Override
  public void outTopClassDecl(TopClassDecl node) {
    mCurrentST.popScope();
  }

  @Override
  public void inMainClass(MainClass node) {
    assert (mCurrentST.getCurrentScope() == mCurrentST.getGlobalScope());
    ClassSTE mainSTE = mCurrentST.lookupClass(node.getName());
    if (mainSTE != null) {
      mCurrentST.pushScope(mainSTE.getScope());
    } else {
      throw new SemanticException(
        "Class [" + node.getName() + "] is not defined under scope " + mCurrentST.getCurrentScope().getName(), 
        node.getLine(),
        node.getPos());
    }
    mCurrentST.pushScope(mainSTE.getScope());
  }
  
  @Override
  public void outMainClass(MainClass node) {
    mCurrentST.popScope();
  }
  
  @Override
  public void outProgram(Program node) {

  }
}

