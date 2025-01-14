# 요구 사항 분석

* 요구사항은 기능적 요구사항과 비기능적 요구사항으로 분리하여 작성한다.

## 기능적 요구사항

* 기능적 요구사항은 예외처리 사항과 기능명세 사항으로 분리한다.

### 예외처리 사항

- 로또 번호는 1부터 45사이의 숫자여야한다. [✔]
- 로또를 발행할 때 한 로또에 대해 숫자가 중복되어선 안된다. [✔]
- 로또 구입 금액은 숫자이외의 값이 입력되어선 안된다. [✔]
- 로또 구입 금액은 1000원단위로 떨어져야한다.[✔]
- 보너스 번호는 숫자이외의 값이 입력되어선 안되고 1부터 45사이의 숫자여야한다. []

### 기능명세 사항

- 초기에 입력된 금액/1000 개의 리스트를 생성한다. [✔]
- 당첨번호와 비교 해주는 기능 [✔]
- 당첨개수 구하는 기능 [✔]
- 입력을 클래스로 만들어 재사용성을 높인다 [✔]
- 수익률 계산값을 클래스로 만들어 관리한다 [✔]
  - 수익률은 반올림 하여 계산 [✔] 

## 비기능적 요구사항

- README.md에서 요구하는 컨벤션 사항 [✔]
- Java Enum 을 적용 [✔]
- else 예약어를 사용하지 않는다. [✔]
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다 [✔]
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다. [✔]