package regex.keyboard.domain.regexkeyboard.convertor;

public interface ConvertorI<D, E> {
    E doToEntity(D dataObject);

    D entityToDo(E entity);
}
