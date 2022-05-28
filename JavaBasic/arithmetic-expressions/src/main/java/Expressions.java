import java.util.StringJoiner;

public class Expressions {

    public static Variable var(String name, int value) {
        //implement this method
        return new Variable(name, value);
    }

    public static Expression val(int value) {
        //implement this method

        return new Expression() {
            @Override
            public int evaluate() {
                return value;
            }
            @Override
            public String toExpressionString() {
                if (value < 0) return "(" + value + ")";
                else return String.valueOf(value);
            }
        };
    }

    public static Expression sum(Expression... members){
        //implement this method
        if(members.length < 2) return null;
        return new Expression() {
            @Override
            public int evaluate() {
                int sum = 0;
                for (Expression member : members) {
                    sum += member.evaluate();
                }
                return sum;
            }

            @Override
            public String toExpressionString() {
                String s = "(";
                for (int i = 0; i < members.length - 1; i++) {
                    s = s + members[i].toExpressionString() + " + ";
                }
                s = s + members[members.length - 1].toExpressionString() + ")";
                return s;
            }
        };
    }

    public static Expression product(Expression... members){
        //implement this method
        if(members.length < 2) return null;
        return new Expression() {
            @Override
            public int evaluate() {
                int prod = 1;
                for (Expression member : members) {
                    if(member.evaluate() != 0)
                        prod *= member.evaluate();
                }
                return prod;
            }

            @Override
            public String toExpressionString() {
                String s = "(";
                for (int i = 0; i < members.length - 1; i++) {
                    s = s + members[i].toExpressionString() + " * ";
                }
                s = s + members[members.length - 1].toExpressionString() + ")";
                return s;
            }
        };
    }

    public static Expression difference(Expression minuend, Expression subtrahend){
        //implement this method
        return new Expression() {
            @Override
            public int evaluate() {
                return minuend.evaluate() - subtrahend.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + minuend.toExpressionString() + " - " + subtrahend.toExpressionString() + ")";
            }
        };
    }

    public static Expression fraction(Expression dividend, Expression divisor){
        //implement this method
        return new Expression() {
            @Override
            public int evaluate() {
                return dividend.evaluate() / divisor.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + dividend.toExpressionString() + " / " + divisor.toExpressionString() + ")";
            }
        };
    }

}
