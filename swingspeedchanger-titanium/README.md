# Swing Speed Changer

**Minecraft 1.21.11 · Fabric · Created by titanium**

A lightweight client-side Fabric mod that lets you freely customise the hand-swing animation speed — without affecting any game-logic attack cooldowns.

---

## Features

| Feature | Details |
|---|---|
| **Adjustable swing speed** | Set the swing duration from 1 tick (near-instant) to 20 ticks (1 second). Vanilla default is 6. |
| **Toggle on/off** | Enable or disable the override at any time without restarting. |
| **In-game config screen** | Powered by [MidnightLib](https://modrinth.com/mod/midnightlib) — open it via the keybinding or through [ModMenu](https://modrinth.com/mod/modmenu). |
| **Client-side only** | Works on any server; no server-side installation needed. |

---

## Installation

1. Install [Fabric Loader](https://fabricmc.net/use/) **≥ 0.16.14** and **Java 21**.
2. Drop the mod `.jar` into your `mods/` folder.
3. Install [Fabric API](https://modrinth.com/mod/fabric-api).
4. *(Optional)* Install [ModMenu](https://modrinth.com/mod/modmenu) for the in-game config button.

MidnightLib is **bundled** — you do not need to install it separately.

---

## Building from source

```bash
git clone <repo>
cd swingspeedchanger-titanium
./gradlew build
# Output: build/libs/swingspeedchanger-1.0.0.jar
```

Requires **Java 21** and an internet connection for the first build (Gradle downloads Minecraft mappings).

---

## Configuration

Open the config screen in-game (ModMenu or the bound key) and adjust:

- **Enabled** — master on/off toggle
- **Swing Speed** — duration in ticks (1–20, default 6)

Config is saved to `.minecraft/config/swingspeedchanger.json`.

---

## License

[CC0 1.0 Universal](LICENSE) — public domain dedication.
