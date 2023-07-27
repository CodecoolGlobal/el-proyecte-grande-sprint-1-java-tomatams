import { useEffect, useState } from "react";

const UserForm = ({ user, onSave, disabled, onCancel }) => {
  const [passWord, setPassWord] = useState("");
  const [isValidPassword, setIsValidPassword] = useState(null);
  const [displayMessage, setDisplayMessage] = useState("");
  const [errorMessage, setErrorMessage] = useState("");

  const onSubmit = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const entries = [...formData.entries()];

    let user = entries.reduce((acc, entry) => {
      const [k, v] = entry;
      acc[k] = v;
      return acc;
    }, {});
    if (isValidPassword) {
      return onSave(user);
    } else {
      setErrorMessage("The passwords do not match, please correct them")
    }
  };

  const validatePassWord = (e) => {
    const newPassWord = e.target.value;

    const hasUppercase = /[A-Z]/.test(newPassWord);
    const hasLowercase = /[a-z]/.test(newPassWord);
    const hasNumber = /[0-9]/.test(newPassWord);
    const newPassWordLength = newPassWord.length >= 5;

    if (!hasNumber) {
      setErrorMessage("The password has to contain one number!");
      setIsValidPassword(false);
    } else if (!hasUppercase) {
      setErrorMessage("The password has to contain one upperCase letter!");
      setIsValidPassword(false);
    } else if (!hasLowercase) {
      setErrorMessage("The password has to contain one lowerCase letter!");
      setIsValidPassword(false);
    } else if (!newPassWordLength) {
      setErrorMessage("The password is not long enough!");
      setIsValidPassword(false);
    }

    if (hasNumber && hasUppercase && hasLowercase && newPassWordLength) {
      setErrorMessage("");
      setIsValidPassword(true);
    }
    setPassWord(newPassWord)
  }

  const validateConfirmPassWord = (e) => {
    let confPassword = e.target.value;
    if (passWord === confPassword) {
      setErrorMessage("")
      setIsValidPassword(true);
    } else {
      setErrorMessage("passwords do not match")
      setIsValidPassword(false);
    }
  }

  useEffect(() => {
    setDisplayMessage(errorMessage)
  }, [isValidPassword, errorMessage]);

  return (<main>

    <form onSubmit={onSubmit}>
      <div className="form-container">
        <div className="form-fields">
          <label htmlFor="name">Username</label>
          <input
            id="name"
            name="name"
            defaultValue={user ? user.name : null}
            readonly={user}
          ></input>
        </div>

        {user && <div className="form-fields">
          <label htmlFor="old_password">Old password</label>
          <input
            type="password"
            id="old_password"
            name="old_password"
          ></input>
        </div>}

        <div className="form-fields">
          <label htmlFor="password">Password</label>
          <input
            type="password"
            id="password"
            name="password"
            onChange={validatePassWord}
          ></input>
        </div>

        <div className="form-fields">
          <label htmlFor="confirm_password">Confirm password</label>
          <input
            type="password"
            id="conf_password"
            name="conf_password"
            onChange={validateConfirmPassWord}
          ></input>
        </div>

        <div>
          <p>Password Requirements: </p>
          <ul>
            <li>password length needs to be at least 5 characters.</li>
            <li>one uppercase letter</li>
            <li>one lowercase letter</li>
            <li>and one number</li>
          </ul>
        </div>

        <div className="form-fields">
          <label htmlFor="email">Email</label>
          <input
            type="email"
            id="email"
            name="email"
            defaultValue={user ? user.email : null}
          />
        </div>

        <div>
          <p>{displayMessage}</p>
        </div>

        <div className="form-field-buttons">
          <button className="row-button" type="submit" disabled={disabled}>
            {user ? "Update User" : "Create User"}
          </button>
          <button className="row-button" onClick={onCancel}>Cancel</button>
        </div>
      </div>
    </form>
  </main>
  );
};
export default UserForm;

