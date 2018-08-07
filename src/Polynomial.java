public class Polynomial {
    private int arr[];

    Polynomial(String s) {
        this.arr = pre_process(s);
    }

    public int[] pre_process(String s) {
        int[] processed_arr;
        String temp= "";
        if(s.charAt(0)!= '-')
            temp = temp + "+";
        int highestPower=0;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)== '^'){
                if(((s.charAt(i+1) - '0') > highestPower))
                {
                    highestPower = (s.charAt(i+1) - '0');
                }
            }
            if(s.charAt(i) != ' ')
                temp = temp +  s.charAt(i);
        }
        processed_arr = new int[highestPower + 1];
        int j=0;
        while(j<temp.length())
        {
            int mf= 0, coeff=0, power=0;
            if(temp.charAt(j)== '+')
                mf = 1;
            else if(temp.charAt(j)== '-')
                mf = -1;

            j++;
            if(temp.charAt(j)== 'x')
                coeff = 1;
            if((j+1)==temp.length() || (temp.charAt(j+1) == '+' || temp.charAt(j+1) == '-')) {
                coeff = temp.charAt(j) - '0';
                coeff*=mf;
                power = 0;
                j++;
                processed_arr[power] = coeff;
                continue;
            }
            if((j+2)==temp.length() || (temp.charAt(j+2) == '+' || temp.charAt(j+2) == '-'))
            {
                coeff = temp.charAt(j) - '0';
                coeff*=mf;
                power = 1;
                j+=2;
                processed_arr[power] = coeff;
                continue;
            }
            else {
                coeff = temp.charAt(j) - '0';
                j++;
            }
            j+=2;
            power = temp.charAt(j) - '0';
            processed_arr[power] = coeff*mf;
            j++;
        }
        return processed_arr;
    }


    private String get_sign(int number){
        if(number < 0)
            return "-";

        return "+";
    }

    public String post_process(int[] arr){
        StringBuilder s = new StringBuilder();

        for(int i = arr.length - 1; i > -1; i--){
            if(arr[i] != 0)
                s.append(String.format("%s%d%s ", get_sign(arr[i]), arr[i], (i > 0)? "x^" + i: ""));
        }

        String res = s.toString();

        if(res.startsWith("+"))
            res = res.substring(1);

        return res;
    }

    public String multiply(String s){
        int[] ops_arr = pre_process(s);
        int[] res_arr = new int[arr.length + ops_arr.length - 1];

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < ops_arr.length; j++){
                res_arr[i + j] += arr[i] * ops_arr[j];
            }
        }

        return post_process(res_arr);
    }
}
