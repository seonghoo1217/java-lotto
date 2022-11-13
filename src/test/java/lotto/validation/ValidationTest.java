package lotto.validation;

import lotto.BuyLotto;
import lotto.Jackpot;
import lotto.Validation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {

    public static BuyLotto byl;

    public static Jackpot jp;

    @BeforeAll
    static void import_initialize() {
        byl = new BuyLotto();
        jp = new Jackpot();
    }


    @ParameterizedTest
    //given
    @ValueSource(strings = {"a", "abc", "한글_되나요?", "이것도안되야함", "1234", "121200000000002"})
    void validation_user_input_money_유저의_금액_입력값이_유효하지_않을경우_예외발생(String source) {
        //when
        assertThatThrownBy(() -> byl.prepare_money(source))
                .isInstanceOf(IllegalArgumentException.class)
                //then
                .hasMessageContaining("[ERROR] 1000원단위의 숫자를 입력해야합니다");
    }

    @ParameterizedTest
    //given
    @ValueSource(strings = {"1", "123456", "a,b,c,d,e,f", "가,나,다,라,마,바", "1,2,3,4,5"})
    void validation_user_input_jackpot_number_유저의_당첨번호_입력값이_유효하지_않을경우_예외발생(String source) {
        //when
        assertThatThrownBy(() -> jp.jackpot_number_output_and_validate(source))
                .isInstanceOf(IllegalArgumentException.class)
                //then
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 하며 6자리를 입력해야합니다.");
    }

    @ParameterizedTest
    //given
    @ValueSource(strings = {"111", "abc", "가나다"})
    void validation_user_input_bonus_number_유저의_보너스번호_입력값이_유효하지_않을경우_예외발생(String source) {
        //when
        assertThatThrownBy(() -> jp.bonus_number_output_and_validate(source))
                .isInstanceOf(IllegalArgumentException.class)
                //then
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45사이의 숫자여야하며 당첨번호와는 겹쳐선 안됩니다.");
    }

    @ParameterizedTest
    //given
    @ValueSource(strings = {"1","2","3","4","5","6"})
    void validation_user_input_bonus_number_유저의_보너스번호_입력값이_당첨번호와_중복할경우_예외발생(String source) {
        List<String> jackpot_number_list= Arrays.asList("1","2","3","4","5","6");
        Validation.setJackpot_number_list_compare(jackpot_number_list);

        //when
        assertThatThrownBy(() -> jp.bonus_number_output_and_validate(source))
                .isInstanceOf(IllegalArgumentException.class)
                //then
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45사이의 숫자여야하며 당첨번호와는 겹쳐선 안됩니다.");

    }
}