# Contributing Guide

Thanks for your interest in contributing to the **Ride-Hailing App** 🚕✨

This document explains **how to contribute properly**, how branches work, and how to create Pull Requests (PRs). Please read this before starting any work.

---

## 📌 Repository Workflow (Very Important)

We follow a clean and safe workflow:

```
feature/*  →  dev  →  main
```

### Meaning:

* **main** → Stable / final branch (never push directly)
* **dev** → Active development branch
* **feature/*** → Your personal working branches

---

## 🚫 Important Rules

❌ Do NOT push directly to `main`
❌ Do NOT push directly to `dev` (unless maintainer allows it)
✅ Always use a feature branch

---

## 🌿 Branch Naming Convention

Create branches using this format:

```
feature/<short-description>
```

### Examples:

```
feature/login-api
feature/ride-request
feature/payment-module
feature/frontend-ui
```

---

## 🧭 Step-by-Step Contribution Flow

### 1️⃣ Fork the repository

Click **Fork** on GitHub to create your own copy.

---

### 2️⃣ Clone your fork

```bash
git clone https://github.com/<your-username>/Ride-Hailing.git
cd Ride-Hailing
```

---

### 3️⃣ Add upstream (main repository)

```bash
git remote add upstream https://github.com/karansingh21202/Ride-Hailing.git
```

---

### 4️⃣ Create a new feature branch from `dev`

```bash
git checkout dev
git pull upstream dev
git checkout -b feature/your-feature-name
```

---

### 5️⃣ Make your changes

Work inside appropriate folders:

* `backend/` → backend logic
* `frontend/` → UI & frontend code
* `db/` → SQL, schema, seed files

---

### 6️⃣ Commit your changes

Use meaningful commit messages:

```
feat: add ride request endpoint
fix: handle null driver case
docs: update README
```

Command:

```bash
git add .
git commit -m "feat: your message"
```

---

### 7️⃣ Push your branch

```bash
git push origin feature/your-feature-name
```

---

### 8️⃣ Create Pull Request (PR)

On GitHub:

1. Click **Compare & Pull Request**
2. Base branch → `dev`
3. Add title & description
4. Click **Create Pull Request**

---

## ✅ Pull Request Rules

* PR must target `dev`
* At least **1 approval required**
* All comments must be resolved
* Keep PRs small & focused
* One feature per PR

---

## 🧪 Testing Before PR

Before submitting your PR:

* Run the project locally
* Test your feature manually
* Ensure nothing breaks existing code

---

## 📂 Folder Structure(pseudo for your reference to understand)

```
Ride-Hailing/
├── backend/
│   ├── controllers/
│   ├── services/
│   ├── repositories/
│   ├── models/
│   └── config/
│
├── frontend/
│   ├── components/
│   ├── pages/
│   ├── services/
│   └── assets/
│
├── db/
│   ├── schema.sql
│   └── seed.sql
│
├── CONTRIBUTING.md
├── README.md
```

---

## 🧠 Code Guidelines

* Follow clean coding practices
* Use meaningful variable & function names
* Avoid hardcoded values
* Write readable & modular code
* Keep functions small

---

## 🔐 Permissions & Reviews

* Maintainers approve PRs
* Direct push to `main` is blocked
* Direct push to `dev` is restricted

---

## 💬 Need Help?

If you are confused:

* Ask in PR comments
* Open an issue
* Contact the maintainer

---

✅ Thank you for contributing and helping improve this project!
