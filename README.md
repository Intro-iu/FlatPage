# FlatPage
A homepage built with Kotlin & HTML

![b48l4-ng90d](https://github.com/user-attachments/assets/f3dfa2f6-6554-40ed-9aaa-ec62383b4fd8)

## Usage
### Prapare your environment
- [Gradle](https://gradle.org/)
- [Kotlin](https://kotlinlang.org/)

### Clone the repo

```bash
git clone https://github.com/Intro-iu/FlatPage
```

### Launch
Enter the path of FlatPage

```bash
cd FlatPage
```

For Linux:

```bash
gradle run
```

For Windows:

```bash
./gradle.bat run
```
The default port is `8430`, you can visit `http://localhost:8430` to view

### Configure
You can customize this homepage at configure file: `FlatPage/app/src/main/resources/config.toml`

It shoule be in the following format

```toml
[Gereral]
Port = 8430
Title = "Homepage"
Timezone = "Asia/Shanghai"

[[Category]]
categoryName = "APP"
items = [
    { itemName = "Blog", itemIcon = "Blog", itemLink = "#section1" },
    { itemName = "CloudDrive", itemIcon = "CloudDrive", itemLink = "#section2" },
    { itemName = "CodeServer", itemIcon = "CodeServer", itemLink = "#section3" }
]

[[Category]]
categoryName = "API"
items = [
    { itemName = "mqtt", itemIcon = "mqtt", itemLink = "#section4" },
    { itemName = "Database", itemIcon = "Database", itemLink = "#section5" }
]

[[Category]]
categoryName = "Contact"
items = [
    { itemName = "Github", itemIcon = "Github", itemLink = "#section7" },
    { itemName = "Facebook", itemIcon = "Facebook", itemLink = "#section8" },
    { itemName = "X", itemIcon = "X", itemLink = "#section9" }
]

```

