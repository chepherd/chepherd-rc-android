# chepherd-rc-android

Native Android client for chepherd-rc. Kotlin 2.0+, Jetpack Compose, Material 3.

**Privacy by default** — pairs to your bastion daemon over WebRTC DataChannel. Relay only sees the signaling handshake. Your data is your data.

## Project layout

```
chepherd-rc-android/
├── settings.gradle.kts                     # root settings
├── build.gradle.kts                        # root build
├── gradle.properties
├── core/
│   ├── protocol/                           # wire shapes (kotlinx.serialization)
│   │   └── src/main/kotlin/io/chepherd/rc/protocol/
│   │       ├── Envelope.kt
│   │       ├── SequenceCounter.kt
│   │       └── Payloads.kt
│   ├── transport/                          # Transport interface + impls
│   │   └── src/main/kotlin/io/chepherd/rc/transport/
│   │       ├── Transport.kt
│   │       ├── WSTransport.kt
│   │       ├── WebRTCTransport.kt
│   │       ├── SignalingClient.kt
│   │       └── Factory.kt
│   ├── auth/                               # OAuth2 PKCE flow
│   │   └── src/main/kotlin/io/chepherd/rc/auth/
│   │       ├── PKCE.kt
│   │       ├── Auth.kt                     # AppAuth-based flow
│   │       └── TokenStore.kt               # EncryptedSharedPreferences
│   └── style/                              # Design system tokens
│       └── src/main/kotlin/io/chepherd/rc/style/
│           ├── Palette.kt
│           ├── Typography.kt
│           └── Spacing.kt
└── app/                                    # Compose UI + entry point
    └── src/main/kotlin/io/chepherd/rc/
        ├── ChepherdApplication.kt
        ├── ui/
        │   ├── ChepherdTheme.kt
        │   ├── SignInScreen.kt
        │   ├── DashboardScreen.kt
        │   ├── SessionDetailScreen.kt
        │   ├── SessionRow.kt
        │   ├── BandDot.kt
        │   ├── ScorecardView.kt
        │   └── Sparkline.kt
        └── viewmodel/
            └── SessionStore.kt              # MutableStateFlow<List<SessionState>>
```

## Building

```bash
# Requires JDK 17+ and Android SDK 34+
./gradlew assembleDebug
```

## Privacy contract

Same as the web client + the TUI: WebRTC DataChannel is the default; the user can opt into relayed mode for low-trust networks. Tokens stored in `EncryptedSharedPreferences` (AES-256-GCM backed by Android Keystore).

## Design system

Mirrors `chepherd/docs/DESIGN-SYSTEM.md`. The Kotlin palette tokens live in `core/style/src/main/kotlin/io/chepherd/rc/style/Palette.kt` — every hex value comes from the canon mirror in `chepherd/internal/style/palette.go`.

## Status

v0.0 — scaffold + protocol + transport stubs.
