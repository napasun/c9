//
//  MemoListVC.swift
//  Memo
//
//  Created by estgames on 2017. 12. 14..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class MemoListVC: UITableViewController {
    let appDelegate = UIApplication.shared.delegate as! AppDelegate //앱 델리게이트

    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }

    //테이블 뷰의 셀의 개수를 결정
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        let count = self.appDelegate.memolist.count
        return count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let row = self.appDelegate.memolist[indexPath.row]  //주어진 행에 맞는 데이터를 꺼낸다.
        
        let cellId = row.image == nil ? "memoCell" : "memoCellWithImage"
        
        let cell = tableView.dequeueReusableCell(withIdentifier: cellId) as! MemoCell

        cell.subject.text = row.title
        cell.contents.text = row.contents
        cell.img.image = row.image
        
        let formatter = DateFormatter()
        formatter.dateFormat = "yyyy-MM-dd HH:mm:ss"
        cell.regdate.text = formatter.string(from: row.regdate!)

        return cell
    }
    //뷰 컨트롤러가 디바이스의 스크린에 출력될 때 마다 호출됨
    override func viewWillAppear(_ animated: Bool) {
        self.tableView.reloadData() //데이터 갱신
    }
    // 하나 선택 했을 때
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let row = self.appDelegate.memolist[indexPath.row]
        //상세 화면의 인스턴스를 생성한다.
        guard let vc = self.storyboard?.instantiateViewController(withIdentifier: "MemoRead") as? MemoReadVC else {
            return
        }
        //값을 전달하고 상세페이지로 이동
        vc.param = row
        self.navigationController?.pushViewController(vc, animated: true)
    }

}
