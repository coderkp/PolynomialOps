public class Polynomial {
    private int arr[];
    Polynomial(String s)
    {

    }
    public int[] pre_process(String s)
    {
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
        arr = new int[highestPower];
        int j=0;
        return new int[1];
    }

}
