package di_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component : 객체 생성
@Component("tv")
public class SamsungTV implements TV{
	@Autowired //동일한 타입의 객체를 찾아서 매칭시키는 어노테이션
	private Speaker speaker;
	private int price;
	private int width;
	private int height;
	
	public SamsungTV() {
		System.out.println(">>> SamsungTV 생성");
		//필드에 있는 SonySpeaker를 생성자에서 주입
		//speaker = new SonySpeaker();
	}
	public SamsungTV(Speaker speaker) {
		System.out.println(">>> SamsungTV(speaker) - 객체생성");
		this.speaker = speaker;
	}
	public SamsungTV(Speaker speaker, int price) {
		System.out.println(">>> SamsungTV(speaker,price) - 객체생성");
		this.speaker = speaker;
		this.price = price;
	}
	public SamsungTV(Speaker speaker, int width, int height) {
		System.out.println(">>> SamsungTV(speaker,width,height) - 객체생성");
		this.speaker = speaker;
		this.width = width;
		this.height = height;
	}
	
	
	public void powerOn() {
		System.out.println("SamsungTV - 전원 ON");
	}
	public void powerOff() {
		System.out.println("SamsungTV - 전원 OFF");
	}
	public void volumnUp() {
		System.out.println("SamsungTV - 소리크게");
		//speaker = new SonySpeaker();
		speaker.volumnUp();
	}
	public void volumnDown() {
		System.out.println("SamsungTV - 소리작게");
		//speaker = new SonySpeaker();
		speaker.volumnDown();
	}
	//----------------------
	public void initMethod() {
		System.out.println("SamsungTV - initMethod() 실행!!");
	}
	public void destroyMethod() {
		System.out.println("SamsungTV - destroyMethod() 실행!!");
	}
	//--------------------
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "SamsungTV [speaker=" + speaker + ", price=" + price + ", width=" + width + ", height=" + height + "]";
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
}
