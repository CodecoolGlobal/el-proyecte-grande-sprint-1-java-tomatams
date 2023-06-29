const UserLoginForm = ({ user, onSave, disabled, onCancel }) => {

    const onSubmit = (e) => {
      e.preventDefault();
      const formData = new FormData(e.target);
      const entries = [...formData.entries()];
  
      let user = entries.reduce((acc, entry) => {
        const [k, v] = entry;
        acc[k] = v;
        return acc;
      }, {});
  
  
      return onSave(user);
    };
  
    return (<main>
  
      <form onSubmit={onSubmit}>
        <div className="form-container">
          <div className="form-fields">
            <label htmlFor="name">Username</label>
            <input
              id="name"
              name="name"

            ></input>
          </div>
      
  
          <div className="form-fields">
            <label htmlFor="password">Password</label>
            <input
              type="password"
              id="password"
              name="password"

            ></input>
          </div>
  
  
          <div className="form-field-buttons">
            <button className="row-button" type="submit" disabled={disabled}>
               Log in
            </button>
            <button className="row-button" onClick={onCancel}>Cancel</button>
          </div>
        </div>
      </form>
    </main>
    );
  };
  export default UserLoginForm;
  