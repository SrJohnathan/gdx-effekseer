package io.github.srjohnathan.gdx.effekseer.wrapped;

import java.util.function.Function;

/**
 * Wraps a field that references an Effekseer object instance. Requires a getter and setter that will get/set the value in Effekseer.
 */
public class EffekseerFieldWrapper<T> {

    //region State

    private Function<Void, T> getter;
    private Function<T, Void> setter;

    private T value = null;
    private boolean isValueSet = false;

    //endregion

    //region Constructor

    public EffekseerFieldWrapper(Function<Void, T> getter, Function<T, Void> setter) {
        this.getter = getter;
        this.setter = setter;
    }

    //endregion

    //region Public Methods

    /**
     * @return True, if the value has been set anytime during this wrapper's lifetime, otherwise returns false.
     */
    public boolean isValueSet() {
        return this.isValueSet;
    }

    public T get() {
        if (!this.isValueSet()) {
            this.set(this.getter.apply(null));
        }
        return this.value;
    }

    public void set(T value) {
        this.value = value;
        this.isValueSet = true;

        this.setter.apply(value);
    }

    //endregion
}
