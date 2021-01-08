package simple.task.phone;

import java.util.List;
import java.util.Map;

import static java.util.Map.entry;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PhoneNumberTask {

    private PhoneNumberTask() {}

    private static final Map<Character, String> letterToNumberMap = Map.ofEntries(
            entry('a', "2"),
            entry('b', "22"),
            entry('c', "222"),
            entry('d', "3"),
            entry('e', "33"),
            entry('f', "333"),
            entry('g', "4"),
            entry('h', "44"),
            entry('i', "444"),
            entry('j', "5"),
            entry('k', "55"),
            entry('l', "555"),
            entry('m', "6"),
            entry('n', "66"),
            entry('o', "666"),
            entry('p', "7"),
            entry('q', "77"),
            entry('r', "777"),
            entry('s', "7777"),
            entry('t', "8"),
            entry('u', "88"),
            entry('v', "888"),
            entry('w', "9"),
            entry('x', "99"),
            entry('y', "999"),
            entry('z', "9999")
    );

    public static void solve() {
        String phoneNumber = "863105420";
        List<String> words = setupWords();

        System.out.println(solve(phoneNumber, words));
    }

    private static List<String> setupWords() {
        return List.of(
                "foo",      // 333 666 666
                "bar",      // 22 2 777
                "foobar",   // 333 666 666 22 2 777
                "emo",      // 33 6 666
                "cap",      // 222 2 7
                "car",      // 222 2 777
                "cat",      // 222 2 8
                "ga"        // 42
        );
    }

    private static List<String> solve(String phoneNumber, List<String> words) {
        return words.stream()
                .map(PhoneNumberTask::wordToLetters)
                .map(PhoneNumberTask::lettersToNumbers)
                .filter(phoneNumber::contains)
                .collect(toList());
    }

    private static List<Character> wordToLetters(String word) {
        return word.chars()
                .mapToObj(a -> (char) a)
                .collect(toList());
    }

    private static String lettersToNumbers(List<Character> letters) {
        return letters.stream()
                .map(letter -> letterToNumberMap.getOrDefault(letter, letter.toString()))
                .collect(joining());
    }

}
