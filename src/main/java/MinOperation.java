import java.util.Collections;
import java.util.List;

public class MinOperation implements MathOperation {
    @Override
    public Integer calculate(List<Integer> list) {
        return Collections.min(list);
    }
}
