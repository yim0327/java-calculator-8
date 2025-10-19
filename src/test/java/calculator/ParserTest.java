package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ParserTest extends NsTest {
    @Test
    void 다중_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//_=;\\n1_1=1;1,1:1");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
