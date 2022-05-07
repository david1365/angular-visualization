import {Account} from "./account.vo";

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

export class CurrentUser {

  private _account: Account;
  private _token: string;

  constructor(account: Account, token: string) {
    this._account = account;
    this._token = token;
  }

  get account(): Account {
    return this._account;
  }

  set account(value: Account) {
    this._account = value;
  }

  get token(): string {
    return this._token;
  }

  set token(value: string) {
    this._token = value;
  }
}
