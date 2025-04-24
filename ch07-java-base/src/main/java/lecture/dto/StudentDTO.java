package lecture.dto;

import lombok.*;

@NoArgsConstructor //매개변수 없는 생성자
@AllArgsConstructor //모든 필드를 매개변수로 받는 생성자
@RequiredArgsConstructor //final, notnull (필수적으로 초기화시켜야 하는) 이 붙은 필드가 있으면 이 필드만 초기화시키는 생성자
//@ToString //오버라이딩
@Getter
@Setter
// @Data -> RequiredArgsConstructor, Getter, Setter, ToString 모두 포함. 사용 권장되지 않음.

//DTO: Data Transfer Object 데이터를 전달하기 위한 객체
public class StudentDTO {

//    @NonNull
    private String name;
    private int age;
    private String email;

    //이렇게 가져온 데이터 원본은 함부로 수정되어선 안됨.-> getter, setter 사용


    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
