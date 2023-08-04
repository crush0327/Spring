package ex02.nonDI;

public class NewRecordView {
	private NewRecord record;

	/*
	 필요한 객체를 setter method를 통해서 주입 받아서 사용 
	 객체의 생성이 서로 독립적이고 필요시 객체에 주입
	 */
	
	public void setRecord(NewRecord record) {
		this.record = record;
	}
	
	
	public void print() {
		System.out.println("KOR : " + record.getKor());
		System.out.println("ENG : " + record.getEng());
		System.out.println("MATH : " + record.getMath());
		System.out.println("COM : " + record.getCom());
		
		System.out.println(record.total() + " / " + record.avg());
		System.out.println(record.toString());
	}

}
