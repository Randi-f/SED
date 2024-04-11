package ic.doc;

/**
 *@time 11/04/2024 22:05
 *@version 1.0
 *@author fsh
 *@description:
**/
enum Operator {
    PLUS("+"){
        @Override
        public Integer apply(Integer x, Integer y){
            return x+y;
        }
    },
    MINUS("-"){
        @Override
        public Integer apply(Integer x, Integer y){
            return y-x;
        }
    };

    private String label;

    Operator(String label){
        this.label=label;
    }
    public String label() {
        return label;
    }

    public abstract Integer apply(Integer x, Integer y);
}
