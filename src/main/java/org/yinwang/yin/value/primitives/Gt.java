package org.yinwang.yin.value.primitives;


import org.yinwang.yin.Util;
import org.yinwang.yin.ast.Node;
import org.yinwang.yin.value.*;

import java.util.List;

public class Gt extends PrimFun {

    public Gt() {
        super(">", 2);
    }


    @Override
    public Value apply(List<Value> args, Node location) {

        Value v1 = args.get(0);
        Value v2 = args.get(1);
        if (v1 instanceof IntValue && v2 instanceof IntValue) {
            return new BoolValue(((IntValue) v1).value > ((IntValue) v2).value);
        }
        if (v1 instanceof FloatValue && v2 instanceof FloatValue) {
            return new BoolValue(((FloatValue) v1).value > ((FloatValue) v2).value);
        }
        if (v1 instanceof FloatValue && v2 instanceof IntValue) {
            return new BoolValue(((FloatValue) v1).value > ((IntValue) v2).value);
        }
        if (v1 instanceof IntValue && v2 instanceof FloatValue) {
            return new BoolValue(((IntValue) v1).value > ((FloatValue) v2).value);
        }

        Util.abort(location, "incorrect argument types for >: " + v1 + ", " + v2);
        return null;
    }


    public Value typecheck(List<Value> args, Node location) {
        Value v1 = args.get(0);
        Value v2 = args.get(1);

        if (!(v1 instanceof IntType || v1 instanceof FloatValue) ||
                !(v2 instanceof IntType || v2 instanceof FloatValue))
        {
            Util.abort(location, "incorrect argument types for >: " + v1 + ", " + v2);
        }

        return Type.BOOL;
    }

}
