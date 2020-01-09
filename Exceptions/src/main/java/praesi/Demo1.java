package praesi;

public class Demo1 {

    public  void main1(String[] args) throws Exception {
        throw new Exception("Invalid Arguments");
    }

    public  void main2(String[] args)  {
        throw new RuntimeException("Invalid Input");
    }

    public void main2() throws MySelfWritenException {
        throw new MySelfWritenException("Invalid Input");
    }
}
