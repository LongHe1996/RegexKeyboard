package regex.keyboard.domain.regexKeyboard.convertor;

public interface ConvertorI<D,E> {
    E doToEntity(D dataObject);
    D entityToDo(E entity);
}
