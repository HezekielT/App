import SupportedVideoChecker from './NativeSupportedVideoChecker';

export function VideoCompatibilityChecker(path: string): boolean {
  return SupportedVideoChecker.VideoCompatibilityChecker(path);
}
