package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AdditionOperationTest extends NsTest {
    @Test
    void 연산_결과_Overflow_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2147483645,1,2"))
                        .isInstanceOf(ArithmeticException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
