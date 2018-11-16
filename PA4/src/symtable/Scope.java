/** 
 *
 * @File:      Scope
 * @Brief:     Scope in Symbol Table
 * @Created:   Nov/12/2018
 * @Author:    Jiahao Cai
 *
 */

package symtable;
import java.util.*;


public class Scope {
    private HashMap<String, STE> mDict;
    private String mName;

    public Scope(String name) {
        mDict = new HashMap<String, STE>();
        mName = name;
    }

    public STE lookup(String sym) {
        return mDict.get(sym);
    }
    public boolean insert(STE ste) {
        if (mDict.get(ste.getName()) == null) {
            mDict.put(ste.getName(), ste);
            return true;
        } else {
            return false;
        }
    }
    
    public String getName() {
        return mName;
    }
}