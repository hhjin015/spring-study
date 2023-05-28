# TODO app 만들기

- **todo 생성**
  - todo id 는 중복될 수 없다.
- **todo 조회**
  - 전체 조회, id 를 통한 단건 조회를 지원해야한다
  - 삭제되지 않은 todo 만 조회해야 한다
- **todo 수정**
  - 수정 일시가 업데이트되어야 한다
- **change todo status**
  - 다음 상태로 전환이 가능해야한다
    - PLANNED
    - IN_PROGRESS
    - DONE
- **todo 삭제**
  - memory 에서 삭제하지 않고 삭제되었다는 플래그만 on 한다 (soft delete vs hard delete)

# Step 2 Jdbc Repository 만들기

- InMemoryTodoRepository 를 JdbcRepository 로 변경하기
  - TodoRepository 가 제공하는 4가지 메서드를 Jdbc 를 이용하여 db 에 저장할 수 있도록 한다
- 제약
  - ConnectionPool 을 이용할 것
  - in memory db 말고 진짜 db 를 사용할 것