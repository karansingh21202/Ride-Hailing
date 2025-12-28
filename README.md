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

## 🚨 IMPORTANT: Har Baar Code Likhne Se Pehle!

```bash
git checkout dev
git fetch upstream
git pull upstream dev
git checkout -b feature/your-feature-name
```

> ⚠️ **Ye skip kiya toh:** Merge conflicts, outdated code, PR reject, time waste!
> 
> 📖 **Full guide:** [MEMBER_GUIDE.md](MEMBER_GUIDE.md) → "Upstream Sync"

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

### Setup

```bash
# 1. Clone the repo
git clone https://github.com/karansingh21202/Ride-Hailing.git
cd Ride-Hailing

# 2. Create database
mysql -u root -p
CREATE DATABASE ride_hailing_db;
exit;

# 3. Update database password
# Edit: backend/src/main/resources/hibernate.cfg.xml
# Change: your_password_here → your actual MySQL password

# 4. Build the project
cd backend
mvn clean install

# 5. Deploy to Tomcat
# Copy target/ride-hailing.war to Tomcat's webapps folder
```

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
