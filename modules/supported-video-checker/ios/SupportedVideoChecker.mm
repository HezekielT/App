#import "SupportedVideoChecker.h"
#import <AVFoundation/AVFoundation.h>
#import <React/RCTLog.h>

@implementation SupportedVideoChecker
RCT_EXPORT_MODULE()

// - (NSNumber *)multiply:(double)a b:(double)b {
//     NSNumber *result = @(a + b);

//     return result;
// }

- (BOOL)VideoCompatibilityChecker:(NSString *)filePath {
  	NSURL *url = [NSURL URLWithString:filePath];
    AVAsset *asset = [AVAsset assetWithURL:url];
    RCTLogInfo(@"Pretending to create an event %@", asset.isPlayable ? @"YES" : @"NO");
	return asset.isPlayable;
}

- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeSupportedVideoCheckerSpecJSI>(params);
}

@end
