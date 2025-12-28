# 👥 Team Member Guide

> **⚠️ IMPORTANT:** Har baar kaam shuru karne se pehle ye file padhein!

---

## 🚨 SABSE PEHLE: Upstream Sync Karo! (MUST READ)

### ❓ Upstream sync kya hai?
Jab bhi tum code likhne baitho, **pehle latest code lena zaroori hai**. 

### 💥 Agar sync nahi karoge toh kya hoga?

| Problem | Kya dikkat aayegi |
|---------|-------------------|
| **Merge Conflicts** | Tumhara code aur doosre ka code clash karega |
| **Outdated Code** | Tum purani files pe kaam karoge jo already change ho chuki hain |
| **Duplicate Work** | Jo kaam koi kar chuka hai, tum wahi dobara karoge |
| **PR Reject** | Pull Request merge nahi hoga, conflicts ki wajah se |
| **Time Waste** | Conflicts resolve karne mein ghanton lag jayenge |

### ✅ Hamesha ye karo PEHLE!
```bash
# 1. Dev branch pe jao
git checkout dev

# 2. Latest code lo
git fetch upstream
git pull upstream dev

# 3. Ab apna feature branch banao
git checkout -b feature/your-feature-name
```

> ⚠️ **Warning:** Ye step KABHI skip mat karo! Har baar code likhne se pehle ye commands run karo.

---

## 🛠️ Step 0: Software Install Karo!

### 🍫 Easy Way: Chocolatey Use Karo (Recommended!)

Environment variables ka jhanjhat nahi chahiye? Chocolatey install karo - ye sab auto set kar dega!

**Step 1: Chocolatey Install Karo**
PowerShell (Admin) mein run karo:
```powershell
Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))
```

**Step 2: Pehle check karo, phir install karo:**

```powershell
# ═══════════════════════════════════════════════
# 1. JAVA - Check karo
java -version
# Agar error aaye toh install karo:
choco install temurin17 -y

# ═══════════════════════════════════════════════
# 2. MAVEN - Check karo  
mvn -version
# Agar error aaye toh install karo:
choco install maven -y

# ═══════════════════════════════════════════════
# 3. MYSQL - Check karo
mysql --version
# Agar error aaye toh install karo:
choco install mysql -y

# ═══════════════════════════════════════════════
# 4. GIT - Check karo
git --version
# Agar error aaye toh install karo:
choco install git -y

# ═══════════════════════════════════════════════
# 5. VS CODE - Check karo
code --version
# Agar error aaye toh install karo:
choco install vscode -y
```

> 💡 **Note:** Sirf wahi install karo jo tumhare paas nahi hai!

---

### 📥 Manual Way: Download Links

| Software | Version | Download Link | Verify Command |
|----------|---------|---------------|----------------|
| **Java JDK** | 17+ | [Download](https://adoptium.net/) | `java -version` |
| **Maven** | 3.8+ | [Download](https://maven.apache.org/download.cgi) | `mvn -version` |
| **MySQL** | 8.0+ | [Download](https://dev.mysql.com/downloads/installer/) | `mysql --version` |
| **Tomcat** | 9+ | [Download](https://tomcat.apache.org/download-90.cgi) | - |
| **Git** | Latest | [Download](https://git-scm.com/downloads) | `git --version` |
| **VS Code** | Latest | [Download](https://code.visualstudio.com/) | - |

### ⚙️ Installation Verify Karo
```bash
java -version      # Should show: java version "17.x.x"
mvn -version       # Should show: Apache Maven 3.8.x
git --version      # Should show: git version 2.x.x
mysql --version    # Should show: mysql Ver 8.x.x
```

---

### ❌ Common Installation Mistakes

#### 1. `'java' is not recognized` ya `'mvn' is not recognized`
```
Problem: Environment variables set nahi hain

Solution (Windows):
1. Search: "Environment Variables"
2. Click "Environment Variables"  
3. Under "System Variables" → find "Path" → Edit
4. Add these paths:
   - C:\Program Files\Eclipse Adoptium\jdk-17\bin
   - C:\apache-maven-3.9.6\bin
5. Restart terminal
```

#### 2. MySQL command not found
```
Solution: Add to Path → C:\Program Files\MySQL\MySQL Server 8.0\bin
```

### 🤖 Koi bhi problem ho? AI se help lo!

Agar koi bhi error aaye jo samajh na aaye:
1. Error message copy karo
2. ChatGPT / Claude / Gemini mein paste karo
3. Poocho: "Ye error kaise fix karu?"

> 💡 **Pro Tip:** AI bahut helpful hai debugging mein. Use karo bina hesitation ke!

---

## �📂 Project Structure Samjho (VERY IMPORTANT!)

### Root Folder Location
```
d:\Ride-Hailing\          ← Ye hai tumhara project root
├── backend\              ← Java code yahan hai
├── frontend\             ← HTML/CSS/JS yahan hai
├── db\                   ← SQL files yahan hai
└── docs\                 ← Documentation yahan hai
```

### Backend ka Full Path
```
\Ride-Hailing\backend\src\main\java\com\ridehailing\
                                                    ↑
                                        YE folder hai jahan JAVA files banani hain!
```

---

## 🖱️ Folder kaise navigate karo (VS Code)

### Step 1: Explorer Open Karo
- Left side mein **Explorer** icon click karo (ya `Ctrl + Shift + E`)

### Step 2: Folders Expand Karo
Click sequence:
```
backend → src → main → java → com → ridehailing
```

### Step 3: Apna Folder Dhundho
| Tum ho | Folder dhundho |
|--------|----------------|
| Member 1 | `model`, `repository`, `config` |
| Member 2 | `servlet` → `auth`, `filter`, `util` |
| Member 3 | `servlet` → `ride`, `service` |
| Member 4 | `servlet` → `payment`, `servlet` → `rating`, `service` |
| Member 5 | Project root mein `frontend` folder |

---

## ➕ Nayi File Kaise Banao

### VS Code Method
1. Apne folder pe **Right Click** karo
2. Click **"New File"**
3. File name likho: `MyFile.java`
4. Enter dabao

### Example: Member 3 ko `RideService.java` banana hai

**Step 1: Pehle folder structure samjho:**
```
backend/
└── src/
    └── main/
        └── java/
            └── com/
                └── ridehailing/
                    └── service/        ← YAHAN file banana hai!
                        └── .gitkeep    (ye placeholder hai, ignore karo)
```

**Step 2: VS Code mein navigate karo:**
```
backend → src → main → java → com → ridehailing → service
   ↓       ↓      ↓      ↓      ↓        ↓           ↓
  📁  →   📁  →  📁  →  📁  →  📁   →   📁    →    📁 (RIGHT CLICK HERE!)
```

**Step 3: File banao:**
```
1. "service" folder pe RIGHT CLICK karo
2. Click "New File"
3. Type: RideService.java
4. Press Enter ✓
```

---

## ✏️ Existing File Kaise Edit Karo

1. Explorer mein file pe **double click** karo
2. File editor mein open hogi
3. Changes karo
4. **Ctrl + S** se save karo

---

## 📁 Full Folder Paths (Copy-Paste Ready)

### Member 1 - Database & ORM
```
📁 db\                                                    ← SQL files
📁 backend\src\main\java\com\ridehailing\model\           ← Entity classes
📁 backend\src\main\java\com\ridehailing\repository\      ← DAO classes
📁 backend\src\main\java\com\ridehailing\config\          ← HibernateUtil
📁 backend\src\main\java\com\ridehailing\servlet\vehicle\ ← VehicleServlet
```

### Member 2 - Auth & Security
```
📁 backend\src\main\java\com\ridehailing\servlet\auth\    ← Login/Register servlets
📁 backend\src\main\java\com\ridehailing\filter\          ← AuthFilter, CORSFilter
📁 backend\src\main\java\com\ridehailing\util\            ← PasswordUtil, JwtUtil
```

### Member 3 - Ride Flow
```
📁 backend\src\main\java\com\ridehailing\servlet\ride\    ← Ride servlets
📁 backend\src\main\java\com\ridehailing\service\         ← RideService
```

### Member 4 - Payments & Ratings
```
📁 backend\src\main\java\com\ridehailing\servlet\payment\ ← PaymentServlet
📁 backend\src\main\java\com\ridehailing\servlet\rating\  ← RatingServlet
📁 backend\src\main\java\com\ridehailing\service\         ← PaymentService, RatingService
```

### Member 5 - Frontend
```
📁 frontend\pages\    ← HTML pages
📁 frontend\css\      ← Stylesheets
📁 frontend\js\       ← JavaScript files
📁 docs\              ← API documentation
```

---

## 🔄 Step 1: Pehle Local Code Update Karo!

```bash
# 1. Dev branch pe switch karo
git checkout dev

# 2. Latest code fetch karo
git fetch upstream

# 3. Local dev ko update karo
git pull upstream dev

# 4. Ab apna feature branch banao
git checkout -b feature/your-feature-name
```

> ⚠️ **Warning:** Agar ye step skip karoge toh merge conflicts aayenge!

---

## 👤 Member 1 — Database & ORM Lead

### 📁 Your Folders
```
db/
├── schema.sql          → CREATE TABLE statements
└── seed.sql            → Sample INSERT data

backend/src/main/java/com/ridehailing/
├── model/              → Entity classes (User, Vehicle, Ride, Payment, Rating)
├── repository/         → DAO classes
├── config/             → HibernateUtil.java
└── servlet/vehicle/    → VehicleServlet.java
```

### ✅ Your Tasks
- [ ] Create `schema.sql` with all 5 tables
- [ ] Create `seed.sql` with sample data
- [ ] Create Entity classes with JPA annotations
- [ ] Create Repository classes
- [ ] Update `hibernate.cfg.xml` (add entity mappings)
- [ ] Create `HibernateUtil.java`

### 🔗 Dependencies
- None (You start first!)

---

## 👤 Member 2 — Authentication & Security

### 📁 Your Folders
```
backend/src/main/java/com/ridehailing/
├── servlet/auth/
│   ├── RegisterServlet.java
│   └── LoginServlet.java
├── filter/
│   ├── AuthFilter.java
│   └── CORSFilter.java
└── util/
    ├── PasswordUtil.java    → BCrypt hashing
    ├── JwtUtil.java         → JWT generation/validation
    └── JsonUtil.java        → JSON parsing
```

### ✅ Your Tasks
- [ ] Create `PasswordUtil.java` (BCrypt)
- [ ] Create `JwtUtil.java` (JWT token)
- [ ] Create `JsonUtil.java` (Gson helper)
- [ ] Create `RegisterServlet.java`
- [ ] Create `LoginServlet.java`
- [ ] Create `AuthFilter.java`
- [ ] Create `CORSFilter.java`

### 🔗 Dependencies
- Wait for Member 1 to complete `User.java` entity

---

## 👤 Member 3 — Ride Flow (Core Business)

### 📁 Your Folders
```
backend/src/main/java/com/ridehailing/
├── servlet/ride/
│   ├── RideRequestServlet.java
│   ├── RideAcceptServlet.java
│   ├── RideStartServlet.java
│   ├── RideCompleteServlet.java
│   ├── RideCancelServlet.java
│   └── RideListServlet.java
└── service/
    └── RideService.java
```

### ✅ Your Tasks
- [ ] Create `RideService.java` (business logic)
- [ ] Create all Ride servlets
- [ ] Implement ride status flow: `requested → accepted → ongoing → completed`

### 🔗 Dependencies
- Wait for Member 1: `Ride.java`, `User.java` entities
- Wait for Member 2: `AuthFilter`, `JwtUtil`

---

## 👤 Member 4 — Payments & Ratings

### 📁 Your Folders
```
backend/src/main/java/com/ridehailing/
├── servlet/payment/
│   └── PaymentServlet.java
├── servlet/rating/
│   └── RatingServlet.java
└── service/
    ├── PaymentService.java
    └── RatingService.java
```

### ✅ Your Tasks
- [ ] Create `PaymentService.java`
- [ ] Create `PaymentServlet.java`
- [ ] Create `RatingService.java`
- [ ] Create `RatingServlet.java`

### 🔗 Dependencies
- Wait for Member 1: `Payment.java`, `Rating.java` entities
- Wait for Member 3: Ride completion flow

---

## 👤 Member 5 — Frontend + Documentation

### 📁 Your Folders
```
frontend/
├── index.html
├── pages/
│   ├── login.html
│   ├── register.html
│   ├── rider-dashboard.html
│   └── driver-dashboard.html
├── css/
│   └── styles.css
└── js/
    ├── api.js      → fetch() calls
    ├── auth.js     → login/register logic
    ├── rider.js    → rider dashboard
    └── driver.js   → driver dashboard

docs/
└── API.md          → API documentation
```

### ✅ Your Tasks
- [ ] Create all HTML pages
- [ ] Create CSS styles
- [ ] Create JS files for API calls
- [ ] Write API documentation
- [ ] Update README.md

### 🔗 Dependencies
- Can work in parallel with backend team
- Need API endpoints info from Members 2, 3, 4

---

## 🚨 Common Problems & Solutions

### Problem 1: Merge Conflicts
```bash
# Solution: Always pull before starting work
git checkout dev
git pull upstream dev
git checkout -b feature/new-feature
```

### Problem 2: "Cannot find symbol" errors
```bash
# Solution: Maven install karo
cd backend
mvn clean install -DskipTests
```

### Problem 3: Database connection error
1. Check MySQL is running
2. Check `hibernate.cfg.xml` mein password sahi hai
3. Check database `ride_hailing_db` exists

### Problem 4: 404 on API endpoints
1. Check `web.xml` mein servlet mapping hai
2. Check Tomcat properly deployed

---

## 📋 Work Order (Timeline)

```
Week 1: Member 1 → Database & Entities
        Member 5 → Start Frontend (parallel)

Week 2: Member 2 → Auth (after User entity ready)
        Member 1 → Continue Repositories

Week 3: Member 3 → Ride Flow (after Auth ready)
        Member 4 → Start Payment/Rating

Week 4: Integration & Testing
        All → Bug fixes & Documentation
```

---

## 🔁 Daily Workflow

```bash
# Morning: Sync karo
git checkout dev
git pull upstream dev
git checkout feature/your-branch
git merge dev

# Evening: Push karo
git add .
git commit -m "feat: your message"
git push origin feature/your-branch

# Then: Create Pull Request on GitHub (base: dev)
```

---

## 📞 Need Help?

1. Check this guide first
2. Check CONTRIBUTING.md
3. Ask in PR comments
4. Contact maintainer: @karansingh21202
