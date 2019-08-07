package com.vurtne.proproject.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CommitParentTypeEnum{
    COMMIT_PARENT_TYPE_QUESTION(1),
    COMMIT_PARENT_TYPE_COMMIT(2);

    private Integer parent_type;


    CommitParentTypeEnum(Integer parent_type) {
        this.parent_type = parent_type;
    }

    public static boolean isExist(Integer parent_type){
        for (CommitParentTypeEnum c : CommitParentTypeEnum.values()){
            if (c.parent_type == parent_type){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(parent_type);
    }

    @JsonCreator
    public static CommitParentTypeEnum fromText(Integer parent_type){
        for (CommitParentTypeEnum c : CommitParentTypeEnum.values()){
            if (c.parent_type == parent_type) {
                return c;
            }
        }
        return null;
    }

}