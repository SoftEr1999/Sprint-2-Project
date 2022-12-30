import { Component, OnInit} from '@angular/core';
import { student } from '../student';
import { ActivatedRoute } from '@angular/router';
import { studentService } from '../student.service';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit{
  id: number;
  student: student;
  constructor(private route: ActivatedRoute, private studentService: studentService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.student = new student();
    this.studentService.getStudentById(this.id).subscribe( data => {
      this.student = data;
    });
  }
}
