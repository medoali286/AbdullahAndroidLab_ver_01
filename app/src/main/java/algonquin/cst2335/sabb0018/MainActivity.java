package algonquin.cst2335.sabb0018;

/** This is a page that simulates a login page
 * @author Abdullah Sabbagh
 * @version 1.0
 * @since Version 1.0
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    /** This holds the text at the center of the screens */
    private TextView tv = null;

    /** This holds text being entered by the user */
    private EditText et = null;

    /** This holds the button */
    private Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.textView);
        Button btn = findViewById(R.id.Button);
        EditText et = findViewById(R.id.editText);

        btn.setOnClickListener(clk-> {
            boolean b = false;
            b = CheckPassWordComplexity(et.getText().toString());

            if (b == true) {
                tv.setText("Your password meets the requirements");

            } else {
                tv.setText("You should not pass");

            }
                }
        );
    }

    /**
     *
     * @param pw that this function needs to evaluate that meeting all conditions.
     * @return true if the password entered meets all conditions i.e. Uppercase, Lowercase, Number and Special Character.
     */
    boolean CheckPassWordComplexity(String pw){

        /**
         * These are condition that i need to check to return true or false.
         */
        boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;
        foundUpperCase = foundLowerCase = foundNumber = foundSpecial = false;


        for (char c:pw.toCharArray()) {
            if (Character.isUpperCase(c)) {
                foundUpperCase = true;
                break;
            }
        }
        for (char c:pw.toCharArray()){
            if (Character.isLowerCase(c)){
                foundLowerCase=true;
                break;
            }
        }
        for (char c:pw.toCharArray()){
            if (Character.isDigit(c)){
                foundNumber=true;
                break;
            }
        }
        for (char c:pw.toCharArray()){
            if (isSpecialCharacter(c)){
                foundSpecial=true;
                break;
            }
        }


        /**
         * These expressions are used to display a message to the screen.
         */
        if(!foundUpperCase)
        {
            Toast.makeText(this, "The password is missing an upper case letter", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(!foundLowerCase)
        {
            Toast.makeText(this, "The password is missing an lower case letter", Toast.LENGTH_SHORT).show();
            return false;
        } else if(!foundNumber)
        {
            Toast.makeText(this, "The password is missing Numbers", Toast.LENGTH_SHORT).show();
            return false;
        } else if(!foundSpecial)
        {
            Toast.makeText(this, "The password is missing at least one of #$%^&*!@?", Toast.LENGTH_LONG).show();
            return false;
        }else {
            return true;
        }
    }


    /**
     * This function is used to validate a special characters have been entered.
     * @param c the chacter that i am evaluating
     * @return true or false.
     */
    private boolean isSpecialCharacter(char c)
    {
        switch (c)
        {
            case '#':
            case '$':
            case '%':
            case '^':
            case '&':
            case '*':
            case '!':
            case '@':
            case '?':
            {
                return true;
            }
            default: return false;
        }
    }
}