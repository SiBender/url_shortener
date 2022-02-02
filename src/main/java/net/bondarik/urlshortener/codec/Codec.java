package net.bondarik.urlshortener.codec;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Codec {
    private static final char[] ENCODING_CHARACTERS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                                                       'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                                                       'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                                                       'u', 'v', 'w', 'x', 'y', 'z',
                                                       'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                                                       'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                                                       'U', 'V', 'W', 'X', 'Y', 'Z'};

    private static final int NUMBER_SYSTEM_BASE = ENCODING_CHARACTERS.length;

    private static final Map<Character, Integer> DECODING_CHARACTERS = new HashMap<>();

    static {
        for (int i = 0; i < ENCODING_CHARACTERS.length; i++) {
            DECODING_CHARACTERS.put(ENCODING_CHARACTERS[i], i);
        }
    }

    public String encode(long id) {
        if (id == 0)
            return "0";

        StringBuilder result = new StringBuilder();
        while (id > 0) {
            result.append(ENCODING_CHARACTERS[(int) (id % NUMBER_SYSTEM_BASE)]);
            id /= NUMBER_SYSTEM_BASE;
        }
        return result.reverse().toString();
    }

    public long decode(String encodedId) {
        String filteredId = encodedId.trim();
        if (StringUtils.isEmpty(filteredId.trim()))
            return -1;

        long decodedId = 0L;
        int numberSystemMultiplier = 1;

        char[] encodedChars = filteredId.toCharArray();
        for (int i = encodedChars.length - 1; i >= 0; i--) {
            Integer currentPositionValue =  DECODING_CHARACTERS.get(encodedChars[i]);
            if (currentPositionValue == null)
                return -1;

            decodedId +=  currentPositionValue * numberSystemMultiplier;
            numberSystemMultiplier *= NUMBER_SYSTEM_BASE;
        }
        return decodedId;
    }
}
