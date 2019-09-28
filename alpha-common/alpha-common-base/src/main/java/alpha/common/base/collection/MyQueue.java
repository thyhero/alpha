package alpha.common.base.collection;

/**
 * Created by TangHaiyang on 2019/9/28.
 */
public interface MyQueue<Item> extends Iterable<Item> {

    int size();

    boolean isEmpty();

    MyQueue<Item> add(Item item);

    Item remove() throws Exception;
}
