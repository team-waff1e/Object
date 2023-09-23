# 요구 사항

1. 영화관에서 관람객이 영화를 본다.
2. 영화를 보기 위해서는 티켓이 필요하다.
3. 초대장을 갖고있는 관람객에게는 무료로 티켓과 바꿔준다.
4. 초대장이 없는 관람객은 티켓을 구매해야 한다.
5. 티켓 가격은 영화마다 다르다. ok
6. 티켓은 티켓을 판매하는 곳에서 구매할 수 있다.
7. 구매 방식은 현금, 카드 등 다양한 방법을 지원한다.

# 설명

- `class Main`: `main` 메서드가 있는 클래스
- `class Theater`: 영화와 관람객에 대한 연결을 담당한다.
  - `TicketOffice`에게 의존
  - `ticketOffice.sellTicket()`
- `class TicketOffice`: 영화관에서 티켓 판매와 초대장 교환을 담당한다.
  - `PaymentPolicy`에게 의존
- `class Audience`: 관람객의 결제를 담당한다.
  - `PaymentPolicy`에게 의존
- `interface PaymentPolicy`: 구매 방식에 대한 인터페이스를 정의한다.
- `interface Belongings`: `Audience`의 소지품 가방에 담을 수 있는 인터페이스를 정의한다.
  - 추상 메서드가 없다. (`java.lang.Cloneable`과 유사하게)
  - `class Ticket`
  - `class Invitation`
- `class Movie`: 영화 이름과 가격 정보를 담당한다.