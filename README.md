# test-demo
[최범균님의 tdd 영상](https://youtu.be/6Vt-wKPBbuc) 을 참고하며 작성한 TDD 레포지터리

## 코드 작성 전
### TDD, Test-Driven Development 테스트 주도 개발
- 테스트로부터 시작하는 개발 방식
  - (실패하는) 테스트 코드 작성 - RED
  - 테스트를 통과시킬 만큼 구현 - GREEN
  - 코드 정리(리팩토링) - BLUE

### 맛보기: 암호 검사기
- 다음 규칙을 모두 충족하면 "매우 강함, STRONG"이다.
  - 길이가 8글자 이상
  - 0부터 9사이의 숫자를 포함
  - 대문자 포함
- 2개의 규칙을 충족하면 "보통, NORMAL"이다.
- 1개 이하의 규칙을 충족하면 "약함, WEAK"이다.

## TDD 시연
- 커밋 내역을 따라가면 확인 가능

## 코드 작성 후
### TDD로 했더니
- 테스트가 개발을 주도
- 지속적인 코드 정리
  - 개발 과정에서 리팩토링 진행
- 빠른 피드백
  - 내가 만든 코드가 올바른지 바로 알 수 있음
- 테스트를 통과할 만큼만 코드 작성
  - 필요하지 않은 코드를 미리 작성하지 않음
- (일부) 설계 진행
  - 테스트할 대상 이름, 기능 이름, 결과 타입 등
