# 🚕 Ride-Hailing App

MVP Ride Hailing application using **Java, Servlets, JSP, Hibernate & MySQL**

---

## 📚 Documentation

| Document | Description |
|----------|-------------|
| [📁 PROJECT_STRUCTURE.md](PROJECT_STRUCTURE.md) | **Complete folder structure** - Kya kahan hai |
| [👥 MEMBER_GUIDE.md](MEMBER_GUIDE.md) | **START HERE** - Team assignments & tasks |
| [🤝 CONTRIBUTING.md](CONTRIBUTING.md) | Git workflow & PR rules |
| [📖 docs/API.md](docs/API.md) | API documentation (coming soon) |

---

## ⛔ IMPORTANT: Folder Structure Mat Badlo!

> **🚫 Folders ka naam ya structure KABHI mat badlo!**
> 
> - ❌ Folder rename mat karo
> - ❌ Folder move mat karo  
> - ❌ Naye folders mat banao (chahiye to ask maintainer ki bhai idhar ek folder chahiye hoga will do it)
> - ✅ Sirf files add/edit karo apne assigned folder mein
>
> **Kyun?** Merge conflicts, broken paths, team sync issues aayenge and merge conflics time lega 
>
> **Structure change karna hai?** → Maintainer se karwaa lo but please koi drastic change ni : @karansingh21202

---

## � Daily Workflow (ZAROOR PADHO!)

### 🌅 Jab Bhi Code Likhne Baitho - Ye Karo PEHLE:

```bash
# Step 1: Dev branch pe jao (BHOOLNA MAT!)
git checkout dev

# Step 2: Latest code lo upstream se
git fetch upstream
git pull upstream dev

# Step 3: Feature branch banao
git checkout -b feature/tumhara-feature-name
```

### 🌙 Jab Code Likh Lo - Ye Karo Push Ke Liye:

```bash
# Step 1: Changes dekho
git status

# Step 2: Files add karo
git add .

# Step 3: Commit karo (meaningful message)
git commit -m "feat: tumhara kaam ka description"

# Step 4: Push karo APNE fork pe
git push origin feature/tumhara-feature-name

# Step 5: GitHub pe jao → Create Pull Request (base: dev)
```

---

## ❌ Common Galtiyan - Ye MAT Karo!

| Galti | Problem | Sahi Tarika |
|-------|---------|-------------|
| `git push origin main` | Main branch pe push - **BLOCKED!** | `git push origin feature/xyz` |
| Feature branch seedha banaya | Outdated code se branch bani | Pehle `git checkout dev` + `git pull upstream dev` |
| `git push upstream` | Main repo pe push - **NO ACCESS!** | `git push origin` (apne fork pe) |
| Upstream nahi add kiya | `git pull upstream dev` fail hoga | `git remote add upstream ...` karo |
| Purana branch pe kaam kiya | Merge conflicts aayenge | Har feature ke liye naya branch banao |

### ❓ Kaise Check Karo Sab Sahi Hai?

```bash
# Remote check karo
git remote -v
# Ye dikhna chahiye:
# origin    https://github.com/YOUR-USERNAME/Ride-Hailing.git
# upstream  https://github.com/karansingh21202/Ride-Hailing.git

# Branch check karo
git branch
# * feature/your-branch  ← Tum yahan ho
#   dev

# Status check karo
git status
# On branch feature/your-branch
```

> 📖 **Full guide:** [MEMBER_GUIDE.md](MEMBER_GUIDE.md) → "Daily Workflow"

---

## 🚀 Quick Start

### Prerequisites - Install Karo!

| Software | Version | Download | Verify |
|----------|---------|----------|--------|
| Java JDK | 17+ | [Download](https://adoptium.net/) | `java -version` |
| Maven | 3.8+ | [Download](https://maven.apache.org/download.cgi) | `mvn -version` |
| MySQL | 8.0+ | [Download](https://dev.mysql.com/downloads/installer/) | `mysql --version` |
| Tomcat | 9+ | [Download](https://tomcat.apache.org/download-90.cgi) | - |
| Git | Latest | [Download](https://git-scm.com/downloads) | `git --version` |

> ⚠️ **Error aaye toh?** Check [MEMBER_GUIDE.md](MEMBER_GUIDE.md) → "Common Installation Mistakes"

---

## 🍴 Step 1: FORK Karo (Bahut Zaroori!)

> ⛔ **Seedha Clone MAT Karo!** Pehle Fork karo!

### Fork kya hai?
```
Main Repo (karansingh21202/Ride-Hailing)
           ↓
       [FORK] ← Click this button on GitHub!
           ↓
Your Copy (your-username/Ride-Hailing)  ← Ab ye TUMHARA hai!
           ↓
       [CLONE]
           ↓
Your Local Machine
```

### Fork kaise karo?

1. **GitHub pe jao:** https://github.com/karansingh21202/Ride-Hailing
2. **Right side mein "Fork" button click karo** (Star ke paas)
3. **"Create Fork" click karo**
4. Ab tumhare account mein copy ban gayi!

---

## 📥 Step 2: Apna Fork Clone Karo

> ⚠️ **APNA fork clone karo, main repo NAHI!**

```bash
# ❌ GALAT - Ye mat karo!
git clone https://github.com/karansingh21202/Ride-Hailing.git

# ✅ SAHI - Apna username daalo!
git clone https://github.com/YOUR-USERNAME/Ride-Hailing.git
cd Ride-Hailing
```

**Example:** Agar tumhara GitHub username `rahul123` hai:
```bash
git clone https://github.com/rahul123/Ride-Hailing.git
```

---

## 🔗 Step 3: Upstream Add Karo

```bash
# Main repo ko "upstream" naam se add karo
git remote add upstream https://github.com/karansingh21202/Ride-Hailing.git

# Check karo sahi hai ki nahi
git remote -v
```

**Expected output:**
```
origin    https://github.com/YOUR-USERNAME/Ride-Hailing.git (fetch)
origin    https://github.com/YOUR-USERNAME/Ride-Hailing.git (push)
upstream  https://github.com/karansingh21202/Ride-Hailing.git (fetch)
upstream  https://github.com/karansingh21202/Ride-Hailing.git (push)
```

---

## 🗄️ Step 4: Database Setup

```sql
mysql -u root -p
CREATE DATABASE ride_hailing_db;
exit;
```

---

## ⚙️ Step 5: Password Update Karo

File: `backend/src/main/resources/hibernate.cfg.xml`
```xml
<!-- your_password_here ko apne MySQL password se badlo -->
<property name="hibernate.connection.password">YOUR_MYSQL_PASSWORD</property>
```

---

## 🔨 Step 6: Build Karo

```bash
cd backend
mvn clean install
```

---

## 🚀 Step 7: Run Karo

1. `backend/target/ride-hailing.war` → Copy karo
2. Tomcat ke `webapps/` folder mein paste karo
3. Tomcat start karo
4. Browser: `http://localhost:8080/ride-hailing`

> 📖 **Detailed guide:** [PROJECT_STRUCTURE.md](PROJECT_STRUCTURE.md) → "Local Setup"

---

## 📁 Project Structure

```
Ride-Hailing/
├── backend/              # Java Servlet + Hibernate
│   ├── pom.xml
│   └── src/main/java/com/ridehailing/
│       ├── model/        # Entity classes
│       ├── repository/   # DAO layer
│       ├── service/      # Business logic
│       ├── servlet/      # REST endpoints
│       ├── filter/       # Auth & CORS
│       └── util/         # Helpers (JWT, BCrypt)
│
├── frontend/             # HTML, CSS, Vanilla JS
│   ├── pages/
│   ├── css/
│   └── js/
│
├── db/                   # SQL files
│   ├── schema.sql
│   └── seed.sql
│
└── docs/                 # Documentation
```

---

## 👥 Team

| Role | Responsibility |
|------|---------------|
| Member 1 | Database & ORM |
| Member 2 | Authentication & Security |
| Member 3 | Ride Flow |
| Member 4 | Payments & Ratings |
| Member 5 | Frontend & Docs |

See [MEMBER_GUIDE.md](MEMBER_GUIDE.md) for detailed assignments.

---

## 🔗 API Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/auth/register` | POST | User registration |
| `/api/auth/login` | POST | User login |
| `/api/vehicles` | POST | Register vehicle |
| `/api/rides/request` | POST | Request a ride |
| `/api/rides/{id}/accept` | POST | Accept a ride |
| `/api/rides/{id}/start` | POST | Start a ride |
| `/api/rides/{id}/complete` | POST | Complete a ride |
| `/api/rides/{id}/cancel` | POST | Cancel a ride |
| `/api/rides/requests` | GET | List ride requests |
| `/api/payments` | POST | Make payment |
| `/api/ratings` | POST | Rate user |

---

## 📄 License

This project is for educational purposes.
