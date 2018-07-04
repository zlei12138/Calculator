package st.zlei.com.calculator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textview)
    TextView textview;
    @BindView(R.id.left_brackets)
    Button leftBrackets;
    @BindView(R.id.right_brackets)
    Button rightBrackets;
    @BindView(R.id.sin)
    Button sin;
    @BindView(R.id.cos)
    Button cos;
    @BindView(R.id.tan)
    Button tan;
    @BindView(R.id.p)
    Button p;
    @BindView(R.id.e)
    Button e;
    @BindView(R.id.percent)
    Button percent;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.science)
    LinearLayout science;
    @BindView(R.id.switch_science)
    Switch switchScience;
    private String edit_text = "";
    private int isDoubleEqu = 0;


    @BindView(R.id.edit)
    EditText edit;
    @BindView(R.id.AC)
    Button AC;
    @BindView(R.id.back2)
    Button back;
    @BindView(R.id.division)
    Button division;
    @BindView(R.id.mul)
    Button mul;
    @BindView(R.id.seven)
    Button seven;
    @BindView(R.id.eight)
    Button eight;
    @BindView(R.id.nine)
    Button nine;
    @BindView(R.id.sub)
    Button sub;
    @BindView(R.id.four)
    Button four;
    @BindView(R.id.five)
    Button five;
    @BindView(R.id.six)
    Button six;
    @BindView(R.id.add)
    Button add;
    @BindView(R.id.one)
    Button one;
    @BindView(R.id.two)
    Button two;
    @BindView(R.id.three)
    Button three;
    @BindView(R.id.zero)
    Button zero;
    @BindView(R.id.point)
    Button point;
    @BindView(R.id.equals)
    Button equals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        switchScience.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ViewPropertyAnimator viewPropertyAnimator = science.animate().translationX(0).setDuration(650);
                    viewPropertyAnimator.setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            science.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {

                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
                    viewPropertyAnimator.start();
                }else {
                    ViewPropertyAnimator viewPropertyAnimator = science.animate().translationX(-science.getMeasuredWidth()).setDuration(650);
                    viewPropertyAnimator.setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            science.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
                    viewPropertyAnimator.start();
                }
            }
        });
    }

    @OnClick({R.id.percent, R.id.p, R.id.e, R.id.cos, R.id.tan, R.id.sin, R.id.right_brackets, R.id.left_brackets, R.id.AC, R.id.back2, R.id.division, R.id.mul, R.id.seven, R.id.eight, R.id.nine, R.id.sub, R.id.four, R.id.five, R.id.six, R.id.add, R.id.one, R.id.two, R.id.three, R.id.zero, R.id.point, R.id.equals})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.AC:
                isDoubleEqu = 0;
                reSet();
                break;
            case R.id.back2:
                isDoubleEqu = 0;
                reMoveOne();
                break;
            case R.id.division:
                isDoubleEqu = 0;
                put("/");
                break;
            case R.id.mul:
                isDoubleEqu = 0;
                put("*");
                break;
            case R.id.seven:
                isDoubleEqu = 0;
                put("7");
                break;
            case R.id.eight:
                isDoubleEqu = 0;
                put("8");
                break;
            case R.id.nine:
                isDoubleEqu = 0;
                put("9");
                break;
            case R.id.sub:
                isDoubleEqu = 0;
                put("-");
                break;
            case R.id.four:
                isDoubleEqu = 0;
                put("4");
                break;
            case R.id.five:
                isDoubleEqu = 0;
                put("5");
                break;
            case R.id.six:
                isDoubleEqu = 0;
                put("6");
                break;
            case R.id.add:
                isDoubleEqu = 0;
                put("+");
                break;
            case R.id.one:
                isDoubleEqu = 0;
                put("1");
                break;
            case R.id.two:
                isDoubleEqu = 0;
                put("2");
                break;
            case R.id.three:
                isDoubleEqu = 0;
                put("3");
                break;
            case R.id.zero:
                isDoubleEqu = 0;
                put("0");
                break;
            case R.id.point:
                isDoubleEqu = 0;
                put(".");
                break;
            case R.id.equals:
                isDoubleEqu++;
                size();
                break;
            case R.id.left_brackets:
                isDoubleEqu = 0;
                put("(");
                break;
            case R.id.right_brackets:
                isDoubleEqu = 0;
                put(")");
                break;
            case R.id.sin:
                isDoubleEqu = 0;

                put("sin");
                break;
            case R.id.cos:
                isDoubleEqu = 0;

                put("cos");
                break;
            case R.id.tan:
                isDoubleEqu = 0;

                put("tan");
                break;
            case R.id.p:
                isDoubleEqu = 0;
                put("a");
                break;
            case R.id.e:
                isDoubleEqu = 0;
                put("e");
                break;
            case R.id.percent:
                isDoubleEqu = 0;
                put("%");
                break;
        }
    }

    private void size() {
        if (isDoubleEqu < 2) {
            if (isNumeric(edit_text)) {
                edit.setText(edit_text);
                textview.setText(edit_text);
                edit_text = "";
                return;
            }
            if (edit_text.startsWith("*") || edit_text.startsWith("/") || edit_text.startsWith(")")) {
                edit_text = "ERROR";
                textview.setText(edit_text);
                edit_text = "";
                return;
            }

            if (edit_text.startsWith("(")) {
                if (edit_text.startsWith("*", 1) || edit_text.startsWith("/", 1)) {
                    edit_text = "ERROR";
                    textview.setText(edit_text);
                    edit_text = "";
                    return;
                }
            }

            if (edit_text.startsWith("-") || edit_text.startsWith("+")) {
                edit_text = "0" + edit_text;
            }
            String result = "ERROR";
            try {
                result = CalString.sizeyunsuan(edit_text);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            textview.setText(result);
            edit_text = "";
        }

    }

    private void put(String s) {
        edit_text += s;
        edit.setText(edit_text);
    }

    private void reMoveOne() {
        if (!edit_text.isEmpty()) {
            int length = edit_text.length();
            edit_text = edit_text.substring(0, length - 1);
            edit.setText(edit_text);
        } else {
            edit.setText("");
        }
    }

    private void reSet() {
        edit_text = "";
        edit.setText("");
    }

    public boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
