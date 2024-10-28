import { requireNativeComponent, View } from "react-native";
import type { CustomizedViewProps } from "./types";
import { memo, type ReactNode } from "react";

const CustomView = requireNativeComponent<CustomizedViewProps>('CustomizedView');

function CustomizedView({children, ...props}: CustomizedViewProps) {
    return <CustomView {...props}>{children}</CustomView>
}
export default memo(CustomizedView);
