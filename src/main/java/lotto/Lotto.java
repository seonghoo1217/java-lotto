package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수가 여섯개가 아닙니다.");
        }
    }

    public static void compare_prepare(List<List<Integer>> purchased_lotto,
                                                String jackpot_number,
                                                        String bonus_number){

        for (List<Integer> one_of_lotto : purchased_lotto) {
            Lotto lotto = new Lotto(one_of_lotto);
            compare_list_to_list(lotto, jackpot_number, bonus_number);
        }

    }

    private static void compare_list_to_list(Lotto lotto, String jackpot_number,String bonus_number){
        List<String> jackpot_number_list= Arrays.asList(jackpot_number.split(","));
        List<Integer> lotto_list = lotto.numbers;

        Collections.sort(jackpot_number_list);
        Collections.sort(lotto_list);
        JackpotResult jr=new JackpotResult();
        for (String jackpot : jackpot_number_list) {
            compare_jackpot_number(Integer.parseInt(jackpot), lotto_list,jr);
        }
        if (JackpotResult.return_jackpot_count()!=6){
            compare_bonus_number(Integer.parseInt(bonus_number),lotto_list,jr);
        }
    }

    private static void compare_jackpot_number(int jackpot, List<Integer> lotto_list,
                                                                        JackpotResult jr){
        for (Integer lotto_num : lotto_list) {
            if (jackpot == lotto_num) {
                jr.hit_jackpot();
                break;
            }
        }
    }

    private static void compare_bonus_number(int bonus,List<Integer> lotto_list,
                                                                    JackpotResult jr){
        if (lotto_list.contains(bonus)){
            jr.hit_bonus();
        }
    }
}