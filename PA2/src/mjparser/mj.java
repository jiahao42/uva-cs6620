
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Mon Oct 15 11:09:07 EDT 2018
//----------------------------------------------------

package mjparser;

import java_cup.runtime.*;
import java.util.*;
import java.lang.*;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Mon Oct 15 11:09:07 EDT 2018
  */
public class mj extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public mj() {super();}

  /** Constructor which sets the default scanner. */
  public mj(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public mj(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\014\000\002\002\004\000\002\002\006\000\002\007" +
    "\002\000\002\010\002\000\002\011\002\000\002\006\026" +
    "\000\002\004\013\000\002\005\004\000\002\005\002\000" +
    "\002\003\006\000\002\003\003\000\002\003\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\053\000\004\017\005\001\002\000\004\002\055\001" +
    "\002\000\004\046\006\001\002\000\004\044\007\001\002" +
    "\000\004\037\010\001\002\000\004\061\012\001\002\000" +
    "\004\002\000\001\002\000\004\011\uffff\001\002\000\004" +
    "\011\014\001\002\000\004\032\015\001\002\000\004\034" +
    "\016\001\002\000\004\036\017\001\002\000\004\016\020" +
    "\001\002\000\004\007\021\001\002\000\004\035\022\001" +
    "\002\000\004\041\023\001\002\000\004\042\024\001\002" +
    "\000\004\061\025\001\002\000\004\010\026\001\002\000" +
    "\004\011\027\001\002\000\006\012\ufffe\052\ufffe\001\002" +
    "\000\006\012\ufff9\052\ufff9\001\002\000\006\012\032\052" +
    "\034\001\002\000\004\012\ufffd\001\002\000\006\012\ufffa" +
    "\052\ufffa\001\002\000\004\007\035\001\002\000\010\007" +
    "\040\060\037\064\036\001\002\000\006\010\ufff6\027\ufff6" +
    "\001\002\000\006\010\ufff7\027\ufff7\001\002\000\004\015" +
    "\050\001\002\000\004\027\042\001\002\000\010\007\040" +
    "\060\037\064\036\001\002\000\004\027\044\001\002\000" +
    "\010\007\040\060\037\064\036\001\002\000\004\010\046" +
    "\001\002\000\004\044\047\001\002\000\006\012\ufffb\052" +
    "\ufffb\001\002\000\004\010\051\001\002\000\010\007\040" +
    "\060\037\064\036\001\002\000\006\010\ufff8\027\ufff8\001" +
    "\002\000\004\012\054\001\002\000\004\002\ufffc\001\002" +
    "\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\053\000\004\002\003\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\006\010\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\007\012\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\010" +
    "\027\001\001\000\004\005\030\001\001\000\004\004\032" +
    "\001\001\000\004\011\052\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\003\040\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\003\042\001\001\000\002\001\001\000\004\003\044" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\003\051\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$mj$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$mj$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$mj$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    public PrintWriter out; 
    
    public String programName;

    public void unrecovered_syntax_error(Symbol cur_SymbolValue) {
        report_fatal_error("Fatal syntax error", cur_SymbolValue);
    }
    
    public void report_fatal_error(String message, Object info) {
        report_error(message, info);
        done_parsing();
        Symbol SymbolValue = (Symbol)info;
        mjparser.SymbolValue tok = (mjparser.SymbolValue)SymbolValue.value;
        throw new mjparser.ParseException("Fatal parsing error", 
                                          tok.line, tok.pos);
    }
    
    public void report_error(String message, Object info) {
        Symbol SymbolValue = (Symbol)info;
        mjparser.SymbolValue tok = (mjparser.SymbolValue)SymbolValue.value;
        System.err.println("[" + tok.line + "," + tok.pos + "] " 
                               + message + " at " + tok.toString() );
    }
            

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$mj$actions {
  private final mj parser;

  /** Constructor */
  CUP$mj$actions(mj parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$mj$do_action(
    int                        CUP$mj$act_num,
    java_cup.runtime.lr_parser CUP$mj$parser,
    java.util.Stack            CUP$mj$stack,
    int                        CUP$mj$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$mj$result;

      /* select the action based on the action number */
      switch (CUP$mj$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // exp ::= COLOR_LITERAL 
            {
              Integer RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$mj$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$mj$stack.peek()).right;
		SymbolValue c = (SymbolValue)((java_cup.runtime.Symbol) CUP$mj$stack.peek()).value;
		
        parser.out.println("# Color expression " + c.lexeme);
        parser.out.println("ldi    r22," + c.value);
        parser.out.println("# push one byte expression onto stack");
        parser.out.println("push   r22\n");
        RESULT = c.value;
    
              CUP$mj$result = parser.getSymbolFactory().newSymbol("exp",1, ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // exp ::= INT_LITERAL 
            {
              Integer RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$mj$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$mj$stack.peek()).right;
		SymbolValue n = (SymbolValue)((java_cup.runtime.Symbol) CUP$mj$stack.peek()).value;
		
        parser.out.println("# Load constant int " + n.value);
        parser.out.println("ldi    r24,lo8(" + n.value + ")");
        parser.out.println("ldi    r25,hi8(" + n.value + ")");
        parser.out.println("# push two byte expression onto stack");
        parser.out.println("push   r25");
        parser.out.println("push   r24\n");
        RESULT = n.value;
    
              CUP$mj$result = parser.getSymbolFactory().newSymbol("exp",1, ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // exp ::= LPAREN BYTE RPAREN exp 
            {
              Integer RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$mj$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$mj$stack.peek()).right;
		Integer e = (Integer)((java_cup.runtime.Symbol) CUP$mj$stack.peek()).value;
		
        parser.out.println("# Casting int to byte by popping");
        parser.out.println("# 2 bytes off stack and only pushing low order bits");
        parser.out.println("# back on.  Low order bits are on top of stack.");
        parser.out.println("pop    r24");
        parser.out.println("pop    r25");
        parser.out.println("push   r24\n");
    
              CUP$mj$result = parser.getSymbolFactory().newSymbol("exp",1, ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-3)), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // statement_list ::= 
            {
              Object RESULT =null;

              CUP$mj$result = parser.getSymbolFactory().newSymbol("statement_list",3, ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // statement_list ::= statement_list statement 
            {
              Object RESULT =null;

              CUP$mj$result = parser.getSymbolFactory().newSymbol("statement_list",3, ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-1)), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // statement ::= MEGGYSETPIXEL LPAREN exp COMMA exp COMMA exp RPAREN SEMI 
            {
              Object RESULT =null;
		
        parser.out.println("### Meggy.setPixel(x,y,color) call");
        parser.out.println("# load a one byte expression off stack");
        parser.out.println("pop    r20");
        parser.out.println("# load a one byte expression off stack");
        parser.out.println("pop    r22");
        parser.out.println("# load a one byte expression off stack");
        parser.out.println("pop    r24");
        parser.out.println("call   _Z6DrawPxhhh");
        parser.out.println("call   _Z12DisplaySlatev\n");
    
              CUP$mj$result = parser.getSymbolFactory().newSymbol("statement",2, ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-8)), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // main_class ::= CLASS ID NT$0 LBRACE PUBLIC STATIC VOID MAIN LPAREN STRING LBRACKET RBRACKET ID RPAREN LBRACE NT$1 statement_list RBRACE NT$2 RBRACE 
            {
              Object RESULT =null;
              // propagate RESULT from NT$2
                RESULT = (Object) ((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-1)).value;
		int nameleft = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-18)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-18)).right;
		SymbolValue name = (SymbolValue)((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-18)).value;
		int paramleft = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-7)).left;
		int paramright = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-7)).right;
		SymbolValue param = (SymbolValue)((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-7)).value;
		int listleft = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-3)).left;
		int listright = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-3)).right;
		Object list = (Object)((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-3)).value;
		
            InputStream mainPrologue=null;
            BufferedReader reader=null;
            try {
                System.out.println("Generate epilog using avrF.rtl.s");
                mainPrologue 
                    = this.getClass().getClassLoader().getResourceAsStream(
                        "avrF.rtl.s");
                reader = new BufferedReader(new 
                    InputStreamReader(mainPrologue));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    parser.out.println(line);
                }
            } catch ( Exception e2) {
                e2.printStackTrace();
            }
            finally{
                try{
                    if(mainPrologue!=null) mainPrologue.close();
                    if(reader!=null) reader.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            parser.out.flush();
          
              CUP$mj$result = parser.getSymbolFactory().newSymbol("main_class",4, ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-19)), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // NT$2 ::= 
            {
              Object RESULT =(Object) ((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-2)).value;
		int nameleft = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-16)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-16)).right;
		SymbolValue name = (SymbolValue)((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-16)).value;
		int paramleft = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-5)).left;
		int paramright = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-5)).right;
		SymbolValue param = (SymbolValue)((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-5)).value;
		int listleft = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-1)).left;
		int listright = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-1)).right;
		Object list = (Object)((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-1)).value;


          
              CUP$mj$result = parser.getSymbolFactory().newSymbol("NT$2",7, ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // NT$1 ::= 
            {
              Object RESULT =(Object) ((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-12)).value;
		int nameleft = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-13)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-13)).right;
		SymbolValue name = (SymbolValue)((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-13)).value;
		int paramleft = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-2)).left;
		int paramright = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-2)).right;
		SymbolValue param = (SymbolValue)((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-2)).value;
 
            InputStream mainPrologue=null;
            BufferedReader reader=null;
            try {
                // The syntax for loading a text resource file 
                // from a jar file here:
                // http://www.rgagnon.com/javadetails/java-0077.html
                System.out.println("Generate prolog using avrH.rtl.s");
                mainPrologue 
                    = this.getClass().getClassLoader().getResourceAsStream(
                        "avrH.rtl.s");
                reader = new BufferedReader(new 
                    InputStreamReader(mainPrologue));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    parser.out.println(line);
                }
                parser.out.println("\n");
            } catch ( Exception e2) {
                e2.printStackTrace();
            }
            finally{
                try{
                    if(mainPrologue!=null) mainPrologue.close();
                    if(reader!=null) reader.close();
                }
                catch (IOException e) {
                   e.printStackTrace();
                }
            }
          
              CUP$mj$result = parser.getSymbolFactory().newSymbol("NT$1",6, ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // NT$0 ::= 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$mj$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$mj$stack.peek()).right;
		SymbolValue name = (SymbolValue)((java_cup.runtime.Symbol) CUP$mj$stack.peek()).value;
 java.io.PrintStream sout 
                    = new java.io.PrintStream(
                        new java.io.FileOutputStream(name.lexeme+".java.s"));
                parser.out = new PrintWriter(sout);
                // Check filename is class name, if not exit with error message
                // System.exit(0);   
            
              CUP$mj$result = parser.getSymbolFactory().newSymbol("NT$0",5, ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // program ::= IMPORT MEGGY SEMI main_class 
            {
              Object RESULT =null;

              CUP$mj$result = parser.getSymbolFactory().newSymbol("program",0, ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-3)), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          return CUP$mj$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= program EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$mj$stack.elementAt(CUP$mj$top-1)).value;
		RESULT = start_val;
              CUP$mj$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$mj$stack.elementAt(CUP$mj$top-1)), ((java_cup.runtime.Symbol)CUP$mj$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$mj$parser.done_parsing();
          return CUP$mj$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

