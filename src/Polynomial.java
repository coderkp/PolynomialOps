public class Polynomial {
    private int arr[];
    Polynomial(String s)
    {
        this.arr = pre_process(s);
        System.out.println(arr);
    }
    public int[] pre_process(String s)
    {
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
        System.out.println(highestPower);
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
            System.out.println(power);
            processed_arr[power] = coeff*mf;
            j++;
        }
        return processed_arr;
    }
    public String post_process(int[] arr){
        return "";
    }

}
