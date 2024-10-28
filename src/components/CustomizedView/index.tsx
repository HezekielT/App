import React, { Children, ReactNode } from "react";
import {View} from "react-native";
import type {CustomizedViewProps} from "./types";


function CustomizedView({children, ...props}: CustomizedViewProps) {
   return <View {...props}>{children}</View>
}

export default React.memo(CustomizedView);