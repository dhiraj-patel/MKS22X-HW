public class Driver{
    public static void main(String[] args){

	RunningMedian m=new RunningMedian();
	System.out.println(m.getMedian());
	m.add(1);
	System.out.println(m.getMedian());
	m.add(2);
	System.out.println(m.getMedian());
	m.add(0);
	System.out.println(m.getMedian());
	m.add(3);
	System.out.println(m.getMedian());
	m.add(3);
	m.add(3);
	m.add(3);	
	m.add(3);
	System.out.println(m.getMedian());


    }
}
