package com.kumachev.j3;

import com.kumachev.j3.models.Chordate;
import com.kumachev.j3.models.CommonHedgehog;
import com.kumachev.j3.models.Lynx;
import com.kumachev.j3.models.PallasCat;

import java.util.Collection;

public class Segregator {
    void segregate(Collection<? extends Chordate> srcCollection, Collection<? super CommonHedgehog> collection1,
                   Collection<? super PallasCat> collection2, Collection<? super Lynx> collection3) {
        for (Chordate chordate : srcCollection) {
            if (chordate.getClass() == CommonHedgehog.class) {
                collection1.add(((CommonHedgehog) chordate));
            } else if (chordate.getClass() == PallasCat.class) {
                collection2.add(((PallasCat) chordate));
            } else if (chordate.getClass() == Lynx.class) {
                collection3.add(((Lynx) chordate));
            }
        }
    }
}
