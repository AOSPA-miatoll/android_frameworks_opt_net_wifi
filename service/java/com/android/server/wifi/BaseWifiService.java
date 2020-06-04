/*
 * Copyright (c) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.server.wifi;

import android.content.pm.ParceledListSlice;
import android.net.DhcpInfo;
import android.net.Network;
import android.net.wifi.IActionListener;
import android.net.wifi.IDppCallback;
import android.net.wifi.ILocalOnlyHotspotCallback;
import android.net.wifi.INetworkRequestMatchCallback;
import android.net.wifi.IOnWifiActivityEnergyInfoListener;
import android.net.wifi.IOnWifiUsabilityStatsListener;
import android.net.wifi.IScanResultsCallback;
import android.net.wifi.ISoftApCallback;
import android.net.wifi.ISuggestionConnectionStatusListener;
import android.net.wifi.ITrafficStateCallback;
import android.net.wifi.ITxPacketCountListener;
import android.net.wifi.IWifiNotificationCallback;
import android.net.wifi.IWifiConnectedNetworkScorer;
import android.net.wifi.IWifiManager;
import android.net.wifi.ScanResult;
import android.net.wifi.SoftApConfiguration;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiDppConfig;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSuggestion;
import android.net.wifi.hotspot2.IProvisioningCallback;
import android.net.wifi.hotspot2.OsuProvider;
import android.net.wifi.hotspot2.PasspointConfiguration;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.WorkSource;
import android.os.connectivity.WifiActivityEnergyInfo;

import java.util.List;
import java.util.Map;

/**
 * Empty concrete class implementing IWifiManager with stub methods throwing runtime exceptions.
 *
 * This class is meant to be extended by real implementations of IWifiManager in order to facilitate
 * cross-repo changes to WiFi internal APIs, including the introduction of new APIs, the removal of
 * deprecated APIs, or the migration of existing API signatures.
 *
 * When an existing API is scheduled for removal, it can be removed from IWifiManager.aidl
 * immediately and marked as @Deprecated first in this class. Children inheriting this class are
 * then given a short grace period to update themselves before the @Deprecated stub is removed for
 * good. If the API scheduled for removal has a replacement or an overload (signature change),
 * these should be introduced before the stub is removed to allow children to migrate.
 *
 * When a new API is added to IWifiManager.aidl, a stub should be added in BaseWifiService as
 * well otherwise compilation will fail.
 */
public class BaseWifiService extends IWifiManager.Stub {

    private static final String TAG = BaseWifiService.class.getSimpleName();

    @Override
    public long getSupportedFeatures() {
        throw new UnsupportedOperationException();
    }

    /** @deprecated use {@link #getWifiActivityEnergyInfoAsync} instead */
    @Deprecated
    public WifiActivityEnergyInfo reportActivityInfo() {
        throw new UnsupportedOperationException();
    }

    /** @deprecated use {@link #getWifiActivityEnergyInfoAsync} instead */
    @Deprecated
    public void requestActivityInfo(ResultReceiver result) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getWifiActivityEnergyInfoAsync(IOnWifiActivityEnergyInfoListener listener) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ParceledListSlice getConfiguredNetworks(String packageName, String featureId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ParceledListSlice getPrivilegedConfiguredNetworks(String packageName, String featureId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map<String, Map<Integer, List<ScanResult>>> getAllMatchingFqdnsForScanResults(
            List<ScanResult> scanResults) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map<OsuProvider, List<ScanResult>> getMatchingOsuProviders(
            List<ScanResult> scanResults) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map<OsuProvider, PasspointConfiguration> getMatchingPasspointConfigsForOsuProviders(
            List<OsuProvider> osuProviders) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int addOrUpdateNetwork(WifiConfiguration config, String packageName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addOrUpdatePasspointConfiguration(
            PasspointConfiguration config, String packageName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removePasspointConfiguration(String fqdn, String packageName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<PasspointConfiguration> getPasspointConfigurations(String packageName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<WifiConfiguration> getWifiConfigsForPasspointProfiles(List<String> fqdnList) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void queryPasspointIcon(long bssid, String fileName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int matchProviderWithCurrentNetwork(String fqdn) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deauthenticateNetwork(long holdoff, boolean ess) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeNetwork(int netId, String packageName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean enableNetwork(int netId, boolean disableOthers, String packageName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean disableNetwork(int netId, String packageName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void allowAutojoinGlobal(boolean choice) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void allowAutojoin(int netId, boolean choice) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void allowAutojoinPasspoint(String fqdn, boolean enableAutoJoin) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setMacRandomizationSettingPasspointEnabled(String fqdn, boolean enable) {
        throw new UnsupportedOperationException();
    }

    /** @deprecated use {@link #setPasspointMeteredOverride} instead */
    @Deprecated
    public void setMeteredOverridePasspoint(String fqdn, int meteredOverride) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setPasspointMeteredOverride(String fqdn, int meteredOverride) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean startScan(String packageName, String featureId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<ScanResult> getScanResults(String callingPackage, String callingFeatureId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean disconnect(String packageName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean reconnect(String packageName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean reassociate(String packageName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public WifiInfo getConnectionInfo(String callingPackage, String callingFeatureId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean setWifiEnabled(String packageName, boolean enable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getWifiEnabledState() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getCountryCode() {
        throw new UnsupportedOperationException();
    }

    /** @deprecated use {@link #is5GHzBandSupported} instead */
    @Deprecated
    public boolean isDualBandSupported() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean is5GHzBandSupported() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean is6GHzBandSupported() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isWifiStandardSupported(int standard) {
        throw new UnsupportedOperationException();
    }

    /** @deprecated use {@link WifiManager#isStaApConcurrencySupported()} */
    @Deprecated
    public boolean needs5GHzToAnyApBandConversion() {
        throw new UnsupportedOperationException();
    }

    @Override
    public DhcpInfo getDhcpInfo() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setScanAlwaysAvailable(boolean isAvailable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isScanAlwaysAvailable() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean acquireWifiLock(IBinder lock, int lockType, String tag, WorkSource ws) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateWifiLockWorkSource(IBinder lock, WorkSource ws) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean releaseWifiLock(IBinder lock) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void initializeMulticastFiltering() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isMulticastEnabled() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void acquireMulticastLock(IBinder binder, String tag) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void releaseMulticastLock(String tag) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateInterfaceIpState(String ifaceName, int mode) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean startSoftAp(WifiConfiguration wifiConfig) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean startTetheredHotspot(SoftApConfiguration softApConfig) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean stopSoftAp() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int startLocalOnlyHotspot(ILocalOnlyHotspotCallback callback, String packageName,
            String featureId, SoftApConfiguration customConfig) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void stopLocalOnlyHotspot() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void startWatchLocalOnlyHotspot(ILocalOnlyHotspotCallback callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void stopWatchLocalOnlyHotspot() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getWifiApEnabledState() {
        throw new UnsupportedOperationException();
    }

    @Override
    public WifiConfiguration getWifiApConfiguration() {
        throw new UnsupportedOperationException();
    }

    @Override
    public SoftApConfiguration getSoftApConfiguration() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean setWifiApConfiguration(WifiConfiguration wifiConfig, String packageName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean setSoftApConfiguration(SoftApConfiguration softApConfig, String packageName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void notifyUserOfApBandConversion(String packageName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void enableTdls(String remoteIPAddress, boolean enable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void enableTdlsWithMacAddress(String remoteMacAddress, boolean enable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getCurrentNetworkWpsNfcConfigurationToken() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void enableVerboseLogging(int verbose) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getVerboseLoggingLevel() {
        throw new UnsupportedOperationException();
    }

    /** @deprecated use {@link #allowAutojoinGlobal(boolean)} instead */
    @Deprecated
    public void enableWifiConnectivityManager(boolean enabled) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void disableEphemeralNetwork(String SSID, String packageName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void factoryReset(String packageName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Network getCurrentNetwork() {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte[] retrieveBackupData() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void restoreBackupData(byte[] data) {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte[] retrieveSoftApBackupData() {
        throw new UnsupportedOperationException();
    }

    @Override
    public SoftApConfiguration restoreSoftApBackupData(byte[] data) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void restoreSupplicantBackupData(byte[] supplicantData, byte[] ipConfigData) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void startSubscriptionProvisioning(
            OsuProvider provider, IProvisioningCallback callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerSoftApCallback(
            IBinder binder, ISoftApCallback callback, int callbackIdentifier) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void unregisterSoftApCallback(int callbackIdentifier) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerTrafficStateCallback(
            IBinder binder, ITrafficStateCallback callback, int callbackIdentifier) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void unregisterTrafficStateCallback(int callbackIdentifier) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerNetworkRequestMatchCallback(
            IBinder binder, INetworkRequestMatchCallback callback, int callbackIdentifier) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void unregisterNetworkRequestMatchCallback(int callbackIdentifier) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int addNetworkSuggestions(
            List<WifiNetworkSuggestion> networkSuggestions, String callingPackageName,
            String callingFeatureId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int removeNetworkSuggestions(
            List<WifiNetworkSuggestion> networkSuggestions, String callingPackageName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<WifiNetworkSuggestion> getNetworkSuggestions(String packageName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String[] getFactoryMacAddresses() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setDeviceMobilityState(int state) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void startDppAsConfiguratorInitiator(IBinder binder, String enrolleeUri,
            int selectedNetworkId, int netRole, IDppCallback callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void startDppAsEnrolleeInitiator(IBinder binder, String configuratorUri,
            IDppCallback callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void enableWifiCoverageExtendFeature(boolean enable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void stopDppSession() throws RemoteException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addOnWifiUsabilityStatsListener(
            IBinder binder, IOnWifiUsabilityStatsListener listener, int listenerIdentifier) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeOnWifiUsabilityStatsListener(int listenerIdentifier) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateWifiUsabilityScore(int seqNum, int score, int predictionHorizonSec) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void connect(WifiConfiguration config, int netId, IBinder binder,
            IActionListener callback, int callbackIdentifier) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void save(WifiConfiguration config, IBinder binder, IActionListener callback,
            int callbackIdentifier) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forget(int netId, IBinder binder, IActionListener callback,
            int callbackIdentifier) {
        throw new UnsupportedOperationException();
    }

    /**
     * @deprecated was only used by CTS test, now fully removed. Please also remove
     * ITxPacketCountListener.aidl when removing this method.
     */
    @Deprecated
    public void getTxPacketCount(String packageName, IBinder binder,
            ITxPacketCountListener callback, int callbackIdentifier) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerScanResultsCallback(IScanResultsCallback callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void unregisterScanResultsCallback(IScanResultsCallback callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerSuggestionConnectionStatusListener(IBinder binder,
            ISuggestionConnectionStatusListener listener,
            int listenerIdentifier, String packageName, String featureId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void unregisterSuggestionConnectionStatusListener(int listenerIdentifier,
            String packageName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int calculateSignalLevel(int rssi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<WifiConfiguration> getWifiConfigForMatchedNetworkSuggestionsSharedWithUser(
            List<ScanResult> scanResults) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean setWifiConnectedNetworkScorer(IBinder binder,
            IWifiConnectedNetworkScorer scorer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clearWifiConnectedNetworkScorer() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map<WifiNetworkSuggestion, List<ScanResult>> getMatchingScanResults(
            List<WifiNetworkSuggestion> networkSuggestions,
            List<ScanResult> scanResults,
            String callingPackage, String callingFeatureId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setScanThrottleEnabled(boolean enable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isScanThrottleEnabled() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map<String, Map<Integer, List<ScanResult>>>
            getAllMatchingPasspointProfilesForScanResults(List<ScanResult> scanResults) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setAutoWakeupEnabled(boolean enable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isAutoWakeupEnabled() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isWifiCoverageExtendFeatureEnabled() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isExtendingWifi() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getCapabilities(String capaType) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int dppAddBootstrapQrCode(String uri) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int dppBootstrapGenerate(WifiDppConfig config) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String dppGetUri(int bootstrap_id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int dppBootstrapRemove(int bootstrap_id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int dppListen(String frequency, int dpp_role, boolean qr_mutual, boolean netrole_ap) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void dppStopListen() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int dppConfiguratorAdd(String curve, String key, int expiry) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int dppConfiguratorRemove(int config_id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int dppStartAuth(WifiDppConfig config) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String dppConfiguratorGetKey(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSoftApWifiStandard() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isVht8ssCapableDevice() {
        throw new UnsupportedOperationException();
    }
    @Override
    public String doDriverCmd(String command) {
        throw new UnsupportedOperationException();
    }

    /* QTI Vendor Dual STA support APIs */

    @Override
    public boolean setWifiEnabled2(String packageName, int staId, boolean enable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean disconnect2(int staId, String packageName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public WifiInfo getConnectionInfo2(int staId, String callingPackage, String callingFeatureId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ParceledListSlice getConfiguredNetworks2(int staId, String packageName, String callingFeatureId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerForWifiNotification(int staId, IBinder binder, IWifiNotificationCallback callback, int callbackIdentifier) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void unregisterForWifiNotification(int staId, int callbackIdentifier) {
        throw new UnsupportedOperationException();
    }
}
