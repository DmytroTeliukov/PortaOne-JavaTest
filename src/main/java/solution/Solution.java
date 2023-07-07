package solution;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public Character solve(String text) {
        if (Objects.isNull(text) || text.isBlank()) {
            throw new RuntimeException("Text should be present!");
        }

        // Current pattern for replacing taken from: https://stackoverflow.com/questions/13946651/matching-special-characters-and-letters-in-regex
        String [] words = text
                .replaceAll("/^[a-zA-Z\\d!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]*$/", " ")
                .split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(words)
                .map(this::getFirstUniqueCharacter)
                .forEach(stringBuilder::append);
        String convertedWord = stringBuilder.toString().replace(" ", "");

        return getFirstUniqueCharacter(convertedWord);
    }

    private Character getFirstUniqueCharacter(String word) {
        Map<Character, Integer> countCharacter = new LinkedHashMap<>();

        word.chars().mapToObj(c -> (char) c)
                .forEach(c -> countCharacter.put(c, countCharacter.getOrDefault(c, 0) + 1));

        var character = countCharacter.entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .findFirst()
                .orElse(null);

        return (Objects.isNull(character)) ? ' ' : character.getKey();
    }
}

