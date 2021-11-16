package filters;

import java.util.Collections;
import java.util.List;

public class RemoveMultipleValues {
    public List<String> remove(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (Collections.frequency(list, list.get(i)) > 1) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }
}
