package com.apps.omnipotent.system.core.page;

import com.apps.omnipotent.system.core.model.Result;

import java.util.List;

public interface PageHandle {

    <T> Result turnPage(Result result, List<T> list, int start, int lengrh);
}
