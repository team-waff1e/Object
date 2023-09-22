# Chapter 1 : 객체, 설계

## 티켓 판매 어플리케이션 설계안

임시적으로 대략적인 설계안만 구상

### 요구 사항

- 작은 소극장을 경영하는 상황
- 소극장의 홍보로 관람객 중 추첨을 통해 선정된 사람에게 무료 초대장 발송
- 공연 시작 시, 관람객 입장
    - 관람객의 초대장 유뮤 판단 후 티켓 구매 필요 여부 판단, 입장

### 설계 고려 사항

- 요구된 기능들의 고려
- 공연장 자체의 변경사항이 발생하거나 다른 공연장에서 프로그램을 구매할 경우를 고려하고자 함
- 현재 공연 뿐 아니라 하나의 공연장에서 다른 공연을 진행할 경우를 고려하고자 함

```java
// 공연장 자체 인터페이스
// 다른 공연장에서 프로그램 사용 시 구현 클래스를 생성해 수용 인원, 초대 인원, 공연을 할 수 있게 함
public interface Theater {
	int capacity; // 관객 수용량 
	int invitationTotal; // 초대할 인원
	Play currentPlay; // 현재 상영중인 공연
	VisitorList list; // 지금까지 방문했던 관객
	
	Theater(int capacity, int invitationTotal, Play play){
		this.capacity = capacity;
		this.invitationTotal = invitationTotal;
		this.currentPlay = play;
	}

	public void setPlay(Play play); // 공연 바꾸기
	public void sendInvitation(); // 관객에게 초대장 발송
	public void checkTicket(Person[] visitors); // 현재 방문하는 관람객들의 티켓 확인
	public void show(Play play); // 공연 상영
}
```

```java
// 공연 클래스
// 상영할 공연에 따라 필요한 정보를 넣은 객체를 생성할 수 있도록 함
// 공연 내용에 따라 클래스 구현
interface Play {
	String playName;
	int price;
	
	public void play();
}
```

```java
// 방문객 클래스
// 사람에 따라 다른 상황에 대해 각 객체를 생성할 수 있는 클래스 작성
public class Person {
	int money;
	int id;
	String name;
	boolean invitation;

	Person(int money, int id, String name){
		this.money = money;
		this.id = id;
		this.name = name;
	}
}
```

```java
// 공연장에 방문한 사람들을 담아두는 저장소 클래스
public class VisitorList {
	private static List<Person> visited = new ArrayList<>();

	public List<Person> getList(); // 저장된 방문객 모두 반환
	public void invite(Person person); // 지정된 사람에게 초대장 발송 (invitation = true)
}
```

### 회고

- Theater  인터페이스에 너무 많은 책임 할당
- 주어진 문제 상황에 대한 면밀한 파악 필요
- 구현해야 하는 문제 상황에 대해 어떠한 객체들을 협업시킬 것인지에 대해 추가 고민 필요
- 하나의 객체의 책임을 명확히 할 것, 책임을 할당한 후 관심사를 면밀히 분리할 것
    - 행동을 하는 주체를 정해야 한다
    - 각 객체들은 어떤 역할을 가지고 서로 의사소통 할 것인가
- Theater 구현 클래스에 어디서 Person 객체 (손님)을 전달해줄 것인지 고민 존재
- Class와 Interface 설계에 대해 추가 공부 필요

---

## 내용 정리

### 모듈의 기능과 정의

- 모듈 : 클래스, 패키지, 라이브러리 등 프로그램을 구성하는 임의의 요소
- 목적
    - 실행 중 제대로 동작
    - 변경을 위해 존재
    - 코드를 읽는 사람과 의사소통

### 객체 : 자율적인 존재

- 객체는 자신의 일을 스스로 처리 할 수 있어야 함
- 다른 객체가 또 다른 객체의 내부에 직접 접근하지 않음
- 객체 내부 상태는 캡슐화
- 객체 간 소통은 메시지를 통해
- 데이터와 프로세스를 동일한 모듈 내부에 위치하도록 함

### 객체지향설계

자율적으로 행동하는 객체들의 공동체를 만든다

변경에 유연하게 대응할 수 있는 코드

- 결합도 : 객체 사이의 의존성
    - 결합도가 높을수록 함께 변경될 확률 증가
    - 결합도를 낮춰 변경이 용이한 설계
- 캡슐화 : 객체 내부의 세부적인 사항 감춤
    - 변경하기 쉬운 객체를 만들기 위해
    - 객체 내부로의 접근을 제한
    - 본인의 책임이 아닌 것에 대해 너무 세세한 정보를 알지 못하도록 함
- 인터페이스 : 외부에 공개해 객체 사이의 직접적 결합도 낮춤
    - 하나의 객체 내부 구현을 변경하더라도 그것을 참조하고 있는 다른 객체를 함께 변경할 필요가 없게 함
- 구현 : 실제 동작
- 응집도 : 밀접하게 연관된 작업만을 수행, 연관성 없는 작업은 다른 객체에게 위임
- 책임의 이동 : 스스로 책임을 수행하는 자율적인 객체들의 공동체를 구성
- 트레이드오프 : 모두를 만족시킬 수는 없다

### 추가 사항

- 손님이 돈을 충분히 가지고 있지 않을 경우 등 예외상황의 발생은 어떻게 처리할까?
- 가능한 상황을 판단하는 것을 다른 객체에서 수행한다면, 결국 절차적인 부분이 일부 포함되는 것일까?