
import type ChildrenProps from '@src/types/utils/ChildrenProps';
import { ReactNode } from 'react';
import { StyleProp } from "react-native";
import { LayoutChangeEvent, ViewStyle } from "react-native";

export type CustomizedViewProps = ChildrenProps & {
  
  children: ReactNode;
  /** Additional styles to add to the component */

  style?: StyleProp<ViewStyle>;

  onLayout?: (event: LayoutChangeEvent) => void;
  collapsable?: boolean

}